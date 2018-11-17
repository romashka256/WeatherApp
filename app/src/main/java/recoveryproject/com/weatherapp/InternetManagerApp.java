package recoveryproject.com.weatherapp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.Callable;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class InternetManagerApp {
    public Single<Boolean> hasInternetConnection() {
        return Single.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                try {
                    // Connect to Google DNS to check for connection
                    int timeoutMs = 1500;
                    Socket socket = new Socket();
                    SocketAddress socketAddress = new InetSocketAddress("8.8.8.8", 53);

                    socket.connect(socketAddress, timeoutMs);
                    socket.close();
                    return true;
                } catch (IOException e) {
                    return false;
                }
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
