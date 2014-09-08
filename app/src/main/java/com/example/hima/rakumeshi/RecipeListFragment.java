package com.example.hima.rakumeshi;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by masato on 9/1/14.
 */
public class RecipeListFragment extends ListFragment implements RecognitionListener {

    SpeechRecognizer mSpeechRecognizer;
    String LOGTAG = "speechRecognizer";

    private Intent intent;

    private int cardPage = 0;

    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recipe_card_list, container, false);
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(getArguments() != null && getArguments().containsKey("recipeData")) {
            String[] recipeData = getArguments().getStringArray("recipeData");
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity()
                    , R.layout.recipe_item_layout, R.id.text1, recipeData);
            setListAdapter(adapter);
        }


        // listener登録
        mSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(getActivity());
        mSpeechRecognizer.setRecognitionListener(this);

        intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getActivity().getPackageName());


        listView = getListView();


        listening();

    }

    public void scrollList(ListView listView, int nextPage) {

        listView.isSmoothScrollbarEnabled();

        //listView.setSelection(nextPage);

        listView.smoothScrollToPosition(nextPage);

        Log.d("scroll","scroll");
    }


    private void listening(){
        mSpeechRecognizer.startListening(intent);
    }

    @Override
    public void onReadyForSpeech(Bundle params) {
        Toast.makeText(getActivity(), "音声認識準備完了 入力してね", Toast.LENGTH_SHORT).show();
    }

    // 音声入力開始
    @Override
    public void onBeginningOfSpeech() {
        //Toast.makeText(this, "入力開始", Toast.LENGTH_SHORT).show();
        Log.v(LOGTAG,"onBeginningOfSpeech");
    }

    // 録音データのフィードバック用
    @Override
    public void onBufferReceived(byte[] buffer) {
        Log.v(LOGTAG,"onBufferReceived");
    }

    // 入力音声のdBが変化した
    @Override
    public void onRmsChanged(float rmsdB) {
        Log.v(LOGTAG,"recieve : " + rmsdB + "dB");
    }

    // 音声入力終了
    @Override
    public void onEndOfSpeech() {
        Toast.makeText(getActivity(), "入力終了", Toast.LENGTH_SHORT);
    }

    // ネットワークエラー又は、音声認識エラー
    @Override
    public void onError(int error) {
        Log.e(LOGTAG, "onError");

        listening();

        switch (error) {
            case SpeechRecognizer.ERROR_AUDIO:
                // 音声データ保存失敗
                break;
            case SpeechRecognizer.ERROR_CLIENT:
                // Android端末内のエラー(その他)
                break;
            case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
                // 権限無し
                break;
            case SpeechRecognizer.ERROR_NETWORK:
                // ネットワークエラー(その他)
                Log.e(LOGTAG, "network error");
                break;
            case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
                // ネットワークタイムアウトエラー
                Log.e(LOGTAG, "network timeout");
                break;
            case SpeechRecognizer.ERROR_NO_MATCH:
                // 音声認識結果無し
                Toast.makeText(getActivity(), "no match Text data", Toast.LENGTH_LONG).show();
                break;
            case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
                // RecognitionServiceへ要求出せず
                break;
            case SpeechRecognizer.ERROR_SERVER:
                // Server側からエラー通知
                break;
            case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
                // 音声入力無し
                Toast.makeText(getActivity(), "no input?", Toast.LENGTH_LONG).show();
                break;
            default:
        }
    }

    // イベント発生時に呼び出される
    @Override
    public void onEvent(int eventType, Bundle params) {
        Log.v(LOGTAG,"onEvent");
    }

    // 部分的な認識結果が得られる場合に呼び出される
    @Override
    public void onPartialResults(Bundle partialResults) {
        Log.v(LOGTAG,"onPartialResults");
    }

    // 認識結果
    @Override
    public void onResults(Bundle results) {
        ArrayList recData = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

        String getData = new String();

        String next = "次";
        String back = "戻る";

        for (int i = 0; i < recData.size(); i++) {

            if( ( (String) recData.get(i)).equals(next)) {

                cardPage++;
                scrollList(listView, cardPage);

                Toast.makeText(getActivity(), next, Toast.LENGTH_SHORT).show();

            } else if( ( (String) recData.get(i)).equals(back)) {

                cardPage--;
                scrollList(listView, cardPage);
                Toast.makeText(getActivity(), back, Toast.LENGTH_SHORT).show();
            }

        }


        //Toast.makeText(this, getData, Toast.LENGTH_SHORT).show();

        Log.d("Input Text", (String)recData.get(0));

        listening();
    }

 /*   @Override
    public void onDestroy() {
        //kill the voice recognizer
        if(mSpeechRecognizer != null){
            mSpeechRecognizer.destroy();
            mSpeechRecognizer = null;
        }
        super.onDestroy();
    }*/

}
