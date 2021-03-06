package dym.unique.funnyball.sharedperference;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by daiyiming on 2016/4/6.
 */
public class GameSharedPreference {

    private final static String SP_NAME = "game_sp";

    public final static String SP_KEY_TOP_SCORE_LINE = "top_score"; // 直线游戏，兼容之前的游戏分数
    public final static String SP_KEY_TOP_SCORE_BESSEL = "top_score_bessel"; // 曲线游戏
    public final static String SP_KEY_TOP_SCORE_FLUSH = "top_score_flush"; // 闪现游戏
    private final static String SP_KEY_IS_CAN_PLAY_SOUNDS = "is_can_play_sounds";

    private static SharedPreferences mSharedPreferences = null;
    private static SharedPreferences.Editor mEditor = null;

    private GameSharedPreference(){}

    public static void init(Context context) {
        mSharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }

    public static void saveTopScore(String type, int score) {
        mEditor.putInt(type, score);
        mEditor.commit();
    }

    public static int getTopScore(String type) {
        return mSharedPreferences.getInt(type, 0);
    }

    public static void saveIsCanPlaySounds(boolean isCanPlaySounds) {
        mEditor.putBoolean(SP_KEY_IS_CAN_PLAY_SOUNDS, isCanPlaySounds);
        mEditor.commit();
    }

    public static boolean getIsCanPlaySounds() {
        return mSharedPreferences.getBoolean(SP_KEY_IS_CAN_PLAY_SOUNDS, true);
    }

}
