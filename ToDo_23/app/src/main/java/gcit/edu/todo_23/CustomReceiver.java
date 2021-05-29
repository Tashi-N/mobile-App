package gcit.edu.todo_23;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {
    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + "gcit.edu.todo_23.ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        String intentAction = intent.getAction();
        if (intentAction != null){
            String toastMessage = "unknown intent action";
            switch (intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = "Power connected!";
                    break;

                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = "Power disconnected!";
                    break;

                case ACTION_CUSTOM_BROADCAST:
                    toastMessage = "Custom Broadcast Received ";
                    break;
            }
            //display the toast
            Toast.makeText(context,toastMessage,Toast.LENGTH_SHORT).show();
        }

        //throw new UnsupportedOperationException("Not yet implemented");
    }
}