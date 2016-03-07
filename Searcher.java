
public class Searcher extends Thread {

    private MainForm mf;

    public Searcher(MainForm mf) {
        this.mf = mf;
    }

    @Override
    public void run() {
        mf.getOutput().setText(null);
        String st = mf.getTextField1().getText();
        String en = mf.getTextField2().getText();
        boolean prime;
        int start, end, checked = 0, cCt = 0, primeFound = 0;
        long startTime = System.currentTimeMillis();
        try {
            start = Integer.parseInt(st);
            end = Integer.parseInt(en);
            if (start <= 0 || end <= 0 || start == end || start > end) {
                throw new Exception();
            }
        } catch (Exception e) {
            mf.getOutput().append("ERROR!!!");
            return;
        }
        mf.getStartBtn().setEnabled(false);
        mf.getStopBtn().setEnabled(true);
        while (start <= end) {
            prime = true;
            if (start % 2 != 0) {
                for (int i = 2; i < start; i++) {
                    if (start % i == 0) {
                        prime = false;
                        break;
                    }
                }
                if (prime) {
                    primeFound++;
                    mf.getOutput().append(start + " ");
                    mf.getFound().setText("Found: " + primeFound);
                    cCt++;
                    if (cCt == 6) {
                        mf.getOutput().append("\n");
                        mf.getOutput().setCaretPosition(mf.getOutput().getDocument().getLength());
                        cCt = 0;
                    }
                }
            }
            long nowTime = System.currentTimeMillis() - startTime;
            mf.getTime().setText("Time: " + nowTime / 1000 + " seconds");
            mf.getChecked().setText("Checked: " + checked);
            checked++;
            start++;
        }
        mf.getStartBtn().setEnabled(true);
        mf.getStopBtn().setEnabled(false);
        this.stop();
    }
}

