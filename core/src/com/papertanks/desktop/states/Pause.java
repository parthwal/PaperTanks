package com.papertanks.desktop.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.papertanks.desktop.PaperTanks;

import javax.xml.transform.Templates;

public class Pause extends State {
    private Texture pause_bg;
    private Rectangle resume;
    private Rectangle mainMenu;
    private Rectangle exit;
    private Rectangle save_game;
    public Pause(GameStateManager gsm) {
        super(gsm);
        pause_bg = new Texture("paperTanks_assets/pause.png");
        resume= new Rectangle(371,384,567,95);
        save_game= new Rectangle(371,269,567,95);
        mainMenu= new Rectangle(371,157,271,95);
        exit= new Rectangle(673,157,71,95);
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            if(resume.contains(Gdx.input.getX(),PaperTanks.HEIGHT-Gdx.input.getY())){
                gsm.set(new gameScreen(gsm));
            }
            if(mainMenu.contains(Gdx.input.getX(), PaperTanks.HEIGHT-Gdx.input.getY())){
                gsm.set(new HomeScreen(gsm));
            }
            if(exit.contains(Gdx.input.getX(), PaperTanks.HEIGHT-Gdx.input.getY())){
                Gdx.app.exit();
            }
            if(save_game.contains(Gdx.input.getX(), PaperTanks.HEIGHT-Gdx.input.getY())){
                gsm.set(new SelectOne(gsm));
            }
        }
    }

    @Override
    protected void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb, float dt) {
        sb.begin();
        sb.draw(pause_bg,0,0,PaperTanks.WIDTH, PaperTanks.HEIGHT);
        sb.end();
    }

    @Override
    public void dispose() {
        gsm.select.dispose();
    }
}
