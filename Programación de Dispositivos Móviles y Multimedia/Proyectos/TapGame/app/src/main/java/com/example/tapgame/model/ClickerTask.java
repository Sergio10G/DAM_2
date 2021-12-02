package com.example.tapgame.model;

import android.os.AsyncTask;
import android.widget.ProgressBar;

public class ClickerTask extends AsyncTask<Void, Integer, Void> {
    private ProgressBar pb;
    UserListener user;

    public ClickerTask(ProgressBar pb, UserListener user) {
        this.pb = pb;
        this.user = user;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        // Main loop. It will add 1 to the counter every 10ms. The counter is then published.
        int i = 0;
        while (true) {
            publishProgress(i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i += 1;
            if (i > 100)
                i = 0;
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        // Here, the progressBar is updated with the value passed by the doInBackground loop.
        pb.setProgress(values[0]);
        if (values[0] == 100) {
            user.incrementScoreWithListener();
        }
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
    }
}
