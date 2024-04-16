package com.example.andriod_game_demo.entities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.andriod_game_demo.MainActivity;
import com.example.andriod_game_demo.R;

public enum GameCharacters {

    PLAYER(R.drawable.goldknight_spritesheet), SKELETON(R.drawable.skeleton_spritesheet);

    private Bitmap spriteSheet;
    private Bitmap[][] sprites = new Bitmap[7][4];
    private BitmapFactory.Options options = new BitmapFactory.Options();

    GameCharacters(int resID) {
        options.inScaled = false;
        spriteSheet = BitmapFactory.decodeResource(MainActivity.getGameContext().getResources() , resID , options);
        for(int j = 0; j < sprites.length; j++){
            for(int i = 0; i < sprites[j].length; i++){
                sprites[j][i] = getScaledBitmap(Bitmap.createBitmap(spriteSheet, 16 * i, 16 * j, 16 ,16));
            }
        }
    }

    public Bitmap getSpriteSheet(){
        return spriteSheet;
    }

    public Bitmap getSprite(int yPos, int xPos){
        return sprites[yPos][xPos];
    }

    private Bitmap getScaledBitmap(Bitmap bitmap){
        return Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() * 7, bitmap.getHeight() * 7, false);
    }

}
