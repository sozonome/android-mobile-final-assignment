package id.ac.umn.keburusarjanainc;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.gms.samples.vision.barcodereader.BarcodeCapture;
import com.google.android.gms.samples.vision.barcodereader.BarcodeGraphic;
import com.google.android.gms.vision.barcode.Barcode;

import java.util.List;

import xyz.belvi.mobilevisionbarcodescanner.BarcodeRetriever;

public class QRCodeScanner extends AppCompatActivity implements BarcodeRetriever{
    private WebView myWebView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_scanner);

        BarcodeCapture barcodeCapture = (BarcodeCapture) getSupportFragmentManager().findFragmentById(R.id.barcode);
        barcodeCapture.setRetrieval(this);
    }

    @Override
    public void onPermissionRequestDenied() {

    }

    @Override
    public void onRetrievedFailed(String reason) {

    }

    @Override
    public void onRetrieved(final Barcode barcode) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
//                AlertDialog.Builder builder = new AlertDialog.Builder(QRCodeScanner.this)
//                        .setTitle("Code Retrieved")
//                        .setMessage(barcode.displayValue);
//                builder.show();
                setContentView(R.layout.activity_result_scan);

                myWebView2 = (WebView)findViewById(R.id.webView2);
                WebSettings webSettings = myWebView2.getSettings();
                myWebView2.setWebViewClient(new WebViewClient());
                myWebView2.loadUrl(barcode.displayValue);
            }
        });
    }

    @Override
    public void onRetrievedMultiple(Barcode closetToClick, List<BarcodeGraphic> barcode) {

    }

    @Override
    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {

    }
}