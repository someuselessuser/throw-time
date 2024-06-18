package kursksu.game.throwtime.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import kursksu.game.throwtime.ThrowTime;
import kursksu.game.throwtime.ui.AnimatedTable;
import kursksu.game.throwtime.ui.ButtonsPanel;
import kursksu.game.throwtime.ui.LabelPanel;
import kursksu.game.throwtime.utils.Constants;
import kursksu.game.throwtime.utils.Manager;

public class MenuScreen extends State {

    private BitmapFont font;
    private Stage stage;
    private Music music;
    private ButtonsPanel buttons;
    private LabelPanel label;

    public MenuScreen(ThrowTime parent, SpriteBatch batch) {
        super(parent, batch);
        stage = new Stage();
        background = new Sprite(Manager.getTexture("Background_mini"));
        buttons = new ButtonsPanel();
        label = new LabelPanel();
    }

    @Override
    public void update(float delta) {
        stage.act(delta);
        batch.begin();
        background.draw(batch);
        batch.end();
        stage.draw();

        if(buttons.isPlayPressed()) {
            label.hide();
            if(!buttons.isAnimate()) {
                buttons.setPlayPressed(false);
                parent.changeScreen(ThrowTime.GAME);
            }
        }
        if(buttons.isSettingsPressed()) {
            if(!buttons.isAnimate()) {
                buttons.setSettingsPressed(false);
                parent.changeScreen(ThrowTime.SETTINGS);
            }
        }
        if(buttons.isExitPressed()) {
            label.hide();
            if(!buttons.isAnimate()) {
                buttons.setExitPressed(false);
                Gdx.app.exit();
            }
        }
    }

    @Override
    public void create() {}

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        label.setX((float) Gdx.graphics.getWidth() / 2);
        label.setY((float) Gdx.graphics.getHeight() / (4.05f / 4f));
        label.setOrientation(AnimatedTable.OrientationFrom.Top);
        label.setMaxTime(0.0f);
        label.hide();

        label.setMaxTime(1.4f);
        label.show();

        buttons.setFillParent(true);
        buttons.setX((float) Gdx.graphics.getWidth() / 2);
        buttons.setY((float) Gdx.graphics.getHeight() / 2);
        buttons.setMaxTime(0.0f);
        buttons.hide();

        buttons.setMaxTime(0.8f);
        buttons.show();

        stage.addActor(buttons);
        stage.addActor(label);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}