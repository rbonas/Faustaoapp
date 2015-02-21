package com.example.rafael.listviewpage;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.AdapterView;
import android.widget.Toast;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends ActionBarActivity {
/*
    String[] ropa ={
            "Faustão é Amor !",
            "Faustão é Vida !",

    };

    int [] imagenes = {

            R.drawable.faustao1,
            R.drawable.faustao2,
            R.drawable.faustao3,
            R.drawable.faustao4
    };

    manejadoraGaleria manejadorGaleria;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //lista
        ListView lista = (ListView) findViewById(R.id.listView1);
        ArrayAdapter Adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,ropa);
        lista.setAdapter(Adapter);

        //galeria de imagenes

        manejadorGaleria = new manejadoraGaleria(getSupportFragmentManager());


        mViewPager = (ViewPager) findViewById(R.id.pager);
        manejadorGaleria.agregarFragmentos(FragmentosImagenes.newInstance(imagenes[0]));
        manejadorGaleria.agregarFragmentos(FragmentosImagenes.newInstance(imagenes[1]));
        manejadorGaleria.agregarFragmentos(FragmentosImagenes.newInstance(imagenes[2]));
        manejadorGaleria.agregarFragmentos(FragmentosImagenes.newInstance(imagenes[3]));
        mViewPager.setAdapter(manejadorGaleria);

    }


    public class manejadoraGaleria extends FragmentPagerAdapter {
        List<Fragment> fragmentos;
        public manejadoraGaleria(FragmentManager fm)
        {
            super(fm);
            fragmentos = new ArrayList<Fragment>();
        }

        public void agregarFragmentos(Fragment xfragmento){

            fragmentos.add(xfragmento);
        }
        @Override
        public Fragment getItem(int position) {
          return fragmentos.get(position);
        }

        @Override
        public int getCount() {
            return fragmentos.size();
        }
    }

    public static class FragmentosImagenes extends Fragment {

       private static final String ARG_IMAGE = "imagen";
       private int imagen;

       public static FragmentosImagenes newInstance(int imagen) {
            FragmentosImagenes fragment = new FragmentosImagenes();
            Bundle args = new Bundle();
            args.putInt(ARG_IMAGE, imagen);
            fragment.setArguments(args);
            fragment.setRetainInstance(true);
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if(getArguments() != null) {
                 imagen = getArguments().getInt(ARG_IMAGE);
            }
        }

        public FragmentosImagenes() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                  Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            ImageView imagenView = (ImageView) rootView.findViewById(R.id.ImageView1);
            imagenView.setImageResource(imagen);
            return rootView;
        }
    }
*/
MediaPlayer mp = new MediaPlayer();
    int position;
    int position2;

    int s1[] = {
            R.raw.tapegandofogo,
            R.raw.famor,
            R.raw.fvida,
            R.raw.fbosta,
            R.raw.eumbosta,
            R.raw.fcompleto,
            R.raw.tendersurrender

    };
    String[] title = new String[]{
            "Tá Pegando Fogo !",
            "Faustão é AMOR !",
            "Faustão é VIDA !",
            "FAUSTÃO É UM BOSTA !",
            "BOSTA",
            "História Completa ",
            "Tendis Surrendis!"};

    int [] imagenes = {

            R.drawable.faustao1,
            R.drawable.faustao2,
            R.drawable.faustao3,
            R.drawable.faustao4
    };

    manejadoraGaleria manejadorGaleria;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView list30 = (ListView) findViewById(R.id.listView1);

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, title);

        list30.setAdapter(adaptador);

        list30.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                method(position);
            }
        });
        //list.setAdapter(adapter);
        //Log.i("ramiro", "llego al final");

        list30.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView parent, View view, int position, long id) {
                //saveas(RingtoneManager.TYPE_RINGTONE, position);
                position2 = position; //utilizo position2 porque la this.position es para onItemClick

                final CharSequence[] items = {"Estabelecer como Ringtone", "Estabelecer como SMS/Notificacão", "Estabelecer como Alarme"};

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item){
                            case 0:
                                saveas(RingtoneManager.TYPE_RINGTONE, position2);
                                Toast.makeText(getApplicationContext(), "Se estabeleceu como Ringtone", Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                saveas(RingtoneManager.TYPE_NOTIFICATION, position2);
                                Toast.makeText(getApplicationContext(), "Se estabeleceu como SMS/Notificacão", Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                saveas(RingtoneManager.TYPE_ALARM, position2);
                                Toast.makeText(getApplicationContext(), "Se estabeleceu como Alarme", Toast.LENGTH_SHORT).show();
                                break;
                        }

                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
                return false;
            }
        });
        manejadorGaleria = new manejadoraGaleria(getSupportFragmentManager());


        mViewPager = (ViewPager) findViewById(R.id.pager);
        manejadorGaleria.agregarFragmentos(FragmentosImagenes.newInstance(imagenes[0]));
        manejadorGaleria.agregarFragmentos(FragmentosImagenes.newInstance(imagenes[1]));
        manejadorGaleria.agregarFragmentos(FragmentosImagenes.newInstance(imagenes[2]));
        manejadorGaleria.agregarFragmentos(FragmentosImagenes.newInstance(imagenes[3]));
        mViewPager.setAdapter(manejadorGaleria);
    }

    public boolean saveas(int type, int position) {
        byte[] buffer = null;
        InputStream fIn = getBaseContext().getResources().openRawResource(
                s1[position]);
        int size = 0;

        try {
            size = fIn.available();
            buffer = new byte[size];
            fIn.read(buffer);
            fIn.close();
        } catch (IOException e) {
            return false;
        }

        String path = Environment.getExternalStorageDirectory().getPath()
                + "/media/audio/ringtones/";

        String filename = title[position];
        Log.i("Faustão", "path: " + path);

        boolean exists = (new File(path)).exists();
        if (!exists) {
            new File(path).mkdirs();
        }

        FileOutputStream save;
        try {
            save = new FileOutputStream(path + filename);
            save.write(buffer);
            save.flush();
            save.close();
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        }

        sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                Uri.parse("file://" + path + filename)));

        File k = new File(path, filename);

        ContentValues values = new ContentValues();
        values.put(MediaStore.MediaColumns.DATA, k.getAbsolutePath());
        values.put(MediaStore.MediaColumns.TITLE, filename);
        values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/ogg");

        // This method allows to change Notification and Alarm tone also. Just
        // pass corresponding type as parameter
        if (RingtoneManager.TYPE_RINGTONE == type) {
            values.put(MediaStore.Audio.Media.IS_RINGTONE, true);
        } else if (RingtoneManager.TYPE_NOTIFICATION == type) {
            values.put(MediaStore.Audio.Media.IS_NOTIFICATION, true);
        } else if (RingtoneManager.TYPE_ALARM == type) {
            values.put(MediaStore.Audio.Media.IS_ALARM, true);
        }

        Uri uri = MediaStore.Audio.Media.getContentUriForPath(k
                .getAbsolutePath());
        Uri newUri = MainActivity.this.getContentResolver().insert(uri, values);
        RingtoneManager.setActualDefaultRingtoneUri(MainActivity.this, type,
                newUri);

        // Insert it into the database
        this.getContentResolver()
                .insert(MediaStore.Audio.Media.getContentUriForPath(k
                        .getAbsolutePath()), values);

        Log.i("Faustão", "chegou ao final da escritura");
        return true;
    }

    public void method(int position){
        if((mp.isPlaying()==true) && (this.position == position))
            mp.stop();
        else{
            this.position = position;
            try{
                mp.reset();                               //resets the media player
                mp.release();                             //release the media player of current audio playing
                mp= MediaPlayer.create(this, s1[position]); //create a new  media player with the selected id
                mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                //mp.prepare(); //salta exception
                mp.seekTo(0);                             //seek to starting of song means time=0 ms
                mp.start();                               //start media player
            }
            catch (Exception e)
            {
                Toast.makeText(getApplication(), "error exception", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {
            System.out.println("Back is called...");
            mp.stop();
            mp.release();
            mp = null;
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
    public class manejadoraGaleria extends FragmentPagerAdapter {
        List<Fragment> fragmentos;
        public manejadoraGaleria(FragmentManager fm)
        {
            super(fm);
            fragmentos = new ArrayList<Fragment>();
        }

        public void agregarFragmentos(Fragment xfragmento){

            fragmentos.add(xfragmento);
        }
        @Override
        public Fragment getItem(int position) {
            return fragmentos.get(position);
        }

        @Override
        public int getCount() {
            return fragmentos.size();
        }
    }

    public static class FragmentosImagenes extends Fragment {

        private static final String ARG_IMAGE = "imagen";
        private int imagen;

        public static FragmentosImagenes newInstance(int imagen) {
            FragmentosImagenes fragment = new FragmentosImagenes();
            Bundle args = new Bundle();
            args.putInt(ARG_IMAGE, imagen);
            fragment.setArguments(args);
            fragment.setRetainInstance(true);
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if(getArguments() != null) {
                imagen = getArguments().getInt(ARG_IMAGE);
            }
        }

        public FragmentosImagenes() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            ImageView imagenView = (ImageView) rootView.findViewById(R.id.ImageView1);
            imagenView.setImageResource(imagen);
            return rootView;
        }
    }


}


