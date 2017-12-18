package mx.com.devare.notificaciones;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_notifi_simple, btn_notifi_acciones, btn_notifi_expandida, btn_notifi_multiple, btn_notifi_bigpicture;
    public static final int NOTIFICACION_ID = 1;
    NotificationCompat.Builder mBuilder;
    NotificationManager notificationManager;
    Intent intent;
    PendingIntent pendingIntent;
    int icono;
    String titulo;
    String mensaje;
    String msjAuxiliar;
    int numMessages=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManager = (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
        inicializarComponentesUI();
        inicializarSetOnclickListener();
    }


    private void inicializarComponentesUI() {
        btn_notifi_simple = (Button) findViewById(R.id.btn_notifi_simple);
        btn_notifi_acciones = (Button) findViewById(R.id.btn_notifi_acciones);
        btn_notifi_expandida = (Button) findViewById(R.id.btn_notifi_expandida);
        btn_notifi_multiple = (Button) findViewById(R.id.btn_notifi_multiple);
        btn_notifi_bigpicture = (Button) findViewById(R.id.btn_notifi_bigpicture);
    }

    private void inicializarSetOnclickListener() {
        btn_notifi_simple.setOnClickListener(this);
        btn_notifi_acciones.setOnClickListener(this);
        btn_notifi_expandida.setOnClickListener(this);
        btn_notifi_multiple.setOnClickListener(this);
        btn_notifi_bigpicture.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_notifi_simple:
                mostrarNotificacionSimple();
                break;

            case R.id.btn_notifi_acciones:
                mostrarNotificacionAcciones();
                break;

            case R.id.btn_notifi_expandida:
                mostrarNotificacionExpandida();
                break;

            case R.id.btn_notifi_multiple:
                mostrarNotificacionMultiple();
                break;


            case R.id.btn_notifi_bigpicture:
                mostrarNotificacionBigPicture();
                break;
        }
    }


    private void mostrarNotificacionSimple() {
        icono = R.mipmap.ic_launcher;
        intent = new Intent(MainActivity.this, MensajeNotificacion.class);
        pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);

        titulo = "Titulo";
        mensaje = "Bienvenido al Curso de Android Certified Professional en develop";
        msjAuxiliar = "Texto auxiliar";

        mBuilder = new NotificationCompat.Builder(getApplicationContext())
                .setContentIntent(pendingIntent)
                .setSmallIcon(icono)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), icono))
                .setContentTitle(titulo)
                .setContentText(mensaje)
                .setContentInfo(msjAuxiliar)
                .setVibrate(new long[]{100, 250, 100, 500})
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setAutoCancel(true);
        notificationManager.notify(NOTIFICACION_ID, mBuilder.build());
    }

    private void mostrarNotificacionAcciones() {
        icono = R.mipmap.ic_launcher;
        intent = new Intent(MainActivity.this, MensajeNotificacion.class);
        pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);

        titulo = "Titulo";
        mensaje = "Bienvenido al Curso de Android Certified Professional en develop";
        msjAuxiliar = "Texto auxiliar";

        mBuilder = new NotificationCompat.Builder(getApplicationContext())
                .setContentIntent(pendingIntent)
                .setSmallIcon(icono)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), icono))
                .setContentTitle(titulo)
                .setContentText(mensaje)
                .setContentInfo(msjAuxiliar)
                .setVibrate(new long[]{100, 250, 100, 500})
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .addAction(R.drawable.ic_phone, "Llamar", pendingIntent)
                .addAction(R.drawable.ic_save, "Guardar", pendingIntent)
                .addAction(R.drawable.ic_share, "compartir", pendingIntent)
                .setAutoCancel(true);
        notificationManager.notify(2, mBuilder.build());
    }

    private void mostrarNotificacionExpandida() {
        icono = R.mipmap.ic_launcher;
        intent = new Intent(MainActivity.this, MensajeNotificacion.class);
        pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);

        titulo = "Titulo";
        mensaje = "Bienvenido al Curso de Android Certified Professional en develop";
        msjAuxiliar = "Texto auxiliar";

        mBuilder = new NotificationCompat.Builder(getApplicationContext())
                .setContentIntent(pendingIntent)
                .setSmallIcon(icono)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), icono))
                .setContentTitle(titulo)
                .setContentText(mensaje)
                .setContentInfo(msjAuxiliar)
                .setVibrate(new long[]{100, 250, 100, 500})
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(mensaje))
                .setAutoCancel(true);
        notificationManager.notify(3, mBuilder.build());

    }

    private void mostrarNotificacionMultiple() {

        icono = R.mipmap.ic_launcher;
        intent = new Intent(MainActivity.this, MensajeNotificacion.class);

        mBuilder = new NotificationCompat.Builder(getApplicationContext())
                .setContentTitle("Nuevo Mensaje")
                .setContentText("tu mensaje recibido")
                .setTicker("Nuevo mensaje de alerta")
                .setSmallIcon(icono)
                .setSubText("Tap to view documentation about notifications.")
                .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_SOUND)
                .setNumber(numMessages);
        numMessages++;

      /* Add Big View Specific Configuration */
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();

        String[] notificationArray = new String[6];
        notificationArray[0] = new String("Primera Notificacion");
        notificationArray[1] = new String("Segunda Notificacion");
        notificationArray[2] = new String("Tercera Notificacion");
        notificationArray[3] = new String("Cuarta Notificacion");
        notificationArray[4] = new String("Quinta Notificacion");
        notificationArray[5] = new String("Sexta Notificacion");

        // Sets a title for the Inbox style big view
        inboxStyle.setBigContentTitle("Titulo grande de detalles:");

        // Moves notificationArray into the big view
        for (int i = 0; i < notificationArray.length; i++) {
            inboxStyle.addLine(notificationArray[i]);
        }

        mBuilder.setStyle(inboxStyle);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MensajeNotificacion.class);

        stackBuilder.addNextIntent(intent);
        pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(pendingIntent);
        notificationManager.notify(4, mBuilder.build());
    }

    private void mostrarNotificacionBigPicture() {

        Uri defaultSound= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        icono = R.mipmap.ic_launcher;
        intent = new Intent(MainActivity.this, MensajeNotificacion.class);
        pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);

        titulo = "Titulo";
        mensaje = "Bienvenido al Curso de Android Certified Professional en develop";
        msjAuxiliar = "Texto auxiliar";

        mBuilder = new NotificationCompat.Builder(getApplicationContext())
                .setContentIntent(pendingIntent)
                .setSmallIcon(icono)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), icono))
                .setVibrate(new long[]{100, 250, 100, 500})
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setSound(defaultSound)
                .setStyle(new NotificationCompat.BigPictureStyle(mBuilder)
                        .bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.ic_phone))
                        .setBigContentTitle(titulo)
                        .setSummaryText(mensaje))
                .setAutoCancel(true);
        notificationManager.notify(3, mBuilder.build());
    }
}
