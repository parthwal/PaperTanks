package com.papertanks.desktop.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.papertanks.desktop.PaperTanks;

import java.awt.*;

public class gameScreen extends State{
    private Texture gameScreen_bg;
    private Rectangle pause;

    protected gameScreen(GameStateManager gsm) {
        super(gsm);
        gameScreen_bg = new Texture("paperTanks_assets/gameScreen.png");
        pause= new Rectangle(617,599,46,65);
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            if(pause.contains(Gdx.input.getX(),PaperTanks.HEIGHT-Gdx.input.getY())){
                gsm.set(new Pause(gsm));
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
            sb.draw(gameScreen_bg,0,0,PaperTanks.WIDTH, PaperTanks.HEIGHT);
            sb.end();
        }

    @Override
    public void dispose() {
        gsm.select.dispose();

    }
}
