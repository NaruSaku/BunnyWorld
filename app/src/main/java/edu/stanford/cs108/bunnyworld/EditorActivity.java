package edu.stanford.cs108.bunnyworld;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class EditorActivity extends AppCompatActivity {
    BunnyShape selected;
    BunnyPage currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    View view;

    public void onCreateNewPage(View view) {
        popupWindow1(view);
        this.view = view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        EditorView editorView = (EditorView) findViewById(R.id.editorView);

        currentPage = editorView.currentPage;
        selected = currentPage.selectedShape;
        // Handle item selection

        switch (item.getItemId()) {
            case R.id.onClickGoTo:
                if (selected == null) {
                    Log.i("null", "null");
                } else {
                    selected.setSelectScript(selected.getSelectedScript() + "onClickGoTo");
                    popupWindow2(view);
                    Log.i(selected.getName(), selected.getSelectScript());
                }

                return true;
            case R.id.onClickPlaySound:

                if (selected == null) {
                    Log.i("null", "null");
                } else {
                    selected.setSelectScript(selected.getSelectedScript() + "onClickPlaySound");
                    popupWindowSound(view);
                    Log.i(selected.getName(), selected.getSelectScript());
                }
                return true;
            case R.id.onClickShow:

                if (selected == null) {
                    Log.i("null", "null");
                } else {
                    selected.setSelectScript(selected.getSelectedScript() + "onClickShow");
                    popupWindowShow(view);
                    Log.i(selected.getName(), selected.getSelectScript());
                }
                return true;
            case R.id.onEnterGoTo:
                if (selected == null) {
                    Log.i("null", "null");
                } else {
                    selected.setSelectScript(selected.getSelectedScript() + "onEnterGoTo");
                    popupWindow2(view);
                    Log.i(selected.getName(), selected.getSelectScript());
                }

                return true;
            case R.id.onEnterPlaySound:
                if (selected == null) {
                    Log.i("null", "null");
                } else {
                    selected.setSelectScript(selected.getSelectedScript() + "onEnterPlaySound");
                    popupWindowSound(view);
                    Log.i(selected.getName(), selected.getSelectScript());
                }

                return true;
            case R.id.onEnterShow:
                if (selected == null) {
                    Log.i("null", "null");
                } else {
                    selected.setSelectScript(selected.getSelectedScript() + "onEnterShow");
                    popupWindowShow(view);
                    Log.i(selected.getName(), selected.getSelectScript());
                }

                return true;
            case R.id.onDropGoTo:
                if (selected == null) {
                    Log.i("null", "null");
                } else {
                    selected.setSelectScript(selected.getSelectedScript() + "onDropGoTo");
                    popupWindow2(view);
                    Log.i(selected.getName(), selected.getSelectScript());
                }

                return true;
            case R.id.onDropPlaySound:
                if (selected == null) {
                    Log.i("null", "null");
                } else {
                    selected.setSelectScript(selected.getSelectedScript() + "onDropPlaySound");
                    popupWindowSound(view);
                    Log.i(selected.getName(), selected.getSelectScript());
                }

                return true;
            case R.id.onDropShow:
                if (selected == null) {
                    Log.i("null", "null");
                } else {
                    selected.setSelectScript(selected.getSelectedScript() + "onDropShow");
                    popupWindowShow(view);
                    Log.i(selected.getName(), selected.getSelectScript());
                }

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void setString() {


    }

    protected void creatNewGame() {

    }

    protected void deletePage() {

    }

    protected void addShape (BunnyShape shape) {
        switch(shape.getType()) {
            case 0: break;


        }

    }
    private void popupWindow1(View v) {
        try {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View layout = inflater.inflate(R.layout.popup_window,null);

            //We need to get the instance of the LayoutInflater, use the context of this activity

            //Inflate the view from a predefined XML layout

            final PopupWindow pw = new PopupWindow(layout, 800, 350, true);
            // display the popup in the center
            pw.showAtLocation(v, Gravity.CENTER, 0, 0);

            Button enterBtn = (Button) layout.findViewById(R.id.createPageEnter_button);
            Button cancelBtn = (Button) layout.findViewById(R.id.createPageCancel_button);

            cancelBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pw.dismiss();
                }
            });


            enterBtn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    EditText editText = (EditText) layout.findViewById(R.id.pageName_text);
                    String newPageName = editText.getText().toString();
                    EditorView editorView = (EditorView) findViewById(R.id.editorView);
                    editorView.createNewPage(newPageName);

                    editText.setText("");
                    pw.dismiss();

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void popupWindow2(View v) {
        try {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View layout = inflater.inflate(R.layout.popup_window2,null);

            //We need to get the instance of the LayoutInflater, use the context of this activity

            //Inflate the view from a predefined XML layout

            final PopupWindow pw = new PopupWindow(layout, 800, 350, true);
            // display the popup in the center
            pw.showAtLocation(v, Gravity.CENTER, 0, 0);

            Button enterBtn = (Button) layout.findViewById(R.id.goToPageEnter_button);
            Button cancelBtn = (Button) layout.findViewById(R.id.goToPageCancel_button);

            cancelBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pw.dismiss();
                }
            });


            enterBtn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    EditText editText = (EditText) layout.findViewById(R.id.page_text);
                    String goToPage = editText.getText().toString();
                    selected.setSelectScript(selected.getSelectScript() + goToPage + "|");
                    editText.setText("");
                    Log.i(selected.getName(), selected.getSelectScript());
                    //This is used to change page which can be used during game
                    /*
                    EditorView editorView = (EditorView) findViewById(R.id.editorView);
                    editorView.openPage(goToPage);
                    */
                    pw.dismiss();


                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void popupWindowSound(View v) {
        try {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View layout = inflater.inflate(R.layout.popup_windowsound,null);

            //We need to get the instance of the LayoutInflater, use the context of this activity

            //Inflate the view from a predefined XML layout

            final PopupWindow pw = new PopupWindow(layout, 800, 350, true);
            // display the popup in the center
            pw.showAtLocation(v, Gravity.CENTER, 0, 0);

            Button enterBtn = (Button) layout.findViewById(R.id.playSoundEnter_button);
            Button cancelBtn = (Button) layout.findViewById(R.id.playSoundCancel_button);

            cancelBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pw.dismiss();
                }
            });


            enterBtn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    EditText editText = (EditText) layout.findViewById(R.id.sound_text);
                    String soundString = editText.getText().toString();
                    selected.setSelectScript(selected.getSelectScript() + soundString + "|");
                    editText.setText("");
                    Log.i(selected.getName(), selected.getSelectScript());
                    //This is used to change page which can be used during game
                    /*
                    EditorView editorView = (EditorView) findViewById(R.id.editorView);
                    editorView.openPage(goToPage);
                    */
                    pw.dismiss();


                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void popupWindowShow(View v) {
        try {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View layout = inflater.inflate(R.layout.popup_windowshow,null);

            //We need to get the instance of the LayoutInflater, use the context of this activity

            //Inflate the view from a predefined XML layout

            final PopupWindow pw = new PopupWindow(layout, 800, 350, true);
            // display the popup in the center
            pw.showAtLocation(v, Gravity.CENTER, 0, 0);

            Button enterBtn = (Button) layout.findViewById(R.id.showEnter_button);
            Button cancelBtn = (Button) layout.findViewById(R.id.showCancel_button);

            cancelBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pw.dismiss();
                }
            });


            enterBtn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    EditText editText = (EditText) layout.findViewById(R.id.show_text);
                    String showString = editText.getText().toString();
                    selected.setSelectScript(selected.getSelectScript() + showString + "|");
                    editText.setText("");
                    Log.i(selected.getName(), selected.getSelectScript());
                    //This is used to change page which can be used during game
                    /*
                    EditorView editorView = (EditorView) findViewById(R.id.editorView);
                    editorView.openPage(goToPage);
                    */
                    pw.dismiss();


                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
