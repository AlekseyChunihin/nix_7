package ua.com.alevel.level3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window implements Runnable {

    JFrame game;
    Box[][] boxes;
    TimerListener t1 = new TimerListener();
    Timer timer = new Timer(Config.SLEEP_MS, t1);

    @Override
    public void run() {
        initGame();
        initBoxes();
        initTimer();
    }

    public void initGame() {
        game = new JFrame();
        game.getContentPane().setLayout(null);
        game.setSize(Config.SIZE * Config.WIDTH, Config.SIZE * Config.HEIGHT);
        game.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        game.setLocationRelativeTo(null);
        game.setVisible(true);
        game.setTitle("Life Game");
    }

    public void initBoxes() {
        boxes = new Box[Config.WIDTH][Config.HEIGHT];
        for (int x = 0; x < Config.WIDTH; x++) {
            for (int y = 0; y < Config.HEIGHT; y++) {
                boxes[x][y] = new Box(x, y);
                game.add(boxes[x][y]);
            }
        }
        for (int x = 0; x < Config.WIDTH; x++) {
            for (int y = 0; y < Config.HEIGHT; y++) {
                for (int sx = -1; sx <= +1; sx++) {
                    for (int sy = -1; sy <= +1; sy++) {
                        if (!(sx == 0 && sy == 0))
                            boxes[x][y].cell.addNear((boxes[(x + sx + Config.WIDTH) % Config.WIDTH][(y + sy + Config.HEIGHT) % Config.HEIGHT].cell));
                    }

                }
            }
        }
        for (int x = 10; x < 15; x++) {
            boxes[x][10].cell.status = Status.LIVE;
            boxes[x][10].setColor();
        }
    }

    private void initTimer() {
        timer.start();
        game.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                timer.stop();
            }
        });
    }

    private class TimerListener implements ActionListener {
        boolean flop = false;

        @Override
        public void actionPerformed(ActionEvent e) {
            flop = !flop;
            for (int x = 0; x < Config.WIDTH; x++) {
                for (int y = 0; y < Config.HEIGHT; y++) {
                    if (flop) {
                        boxes[x][y].dieOrLive();
                    } else {
                        boxes[x][y].bornToLiveDeadToNone();
                    }
                }
            }
        }
    }
}
