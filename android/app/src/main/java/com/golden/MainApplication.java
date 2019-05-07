package com.golden;

import android.app.Application;
import com.skyward.NotificationManager.NotificationManager;
import com.facebook.react.ReactApplication;
import com.swmansion.gesturehandler.react.RNGestureHandlerPackage;
import com.kevinejohn.RNMixpanel.RNMixpanel;
import fr.greweb.reactnativeviewshot.RNViewShotPackage;
import cl.json.RNSharePackage;
import cl.json.ShareApplication;

import com.oblador.shimmer.RNShimmerPackage;
import com.rnfingerprint.FingerprintAuthPackage;

import org.devio.rn.splashscreen.SplashScreenReactPackage;

import com.bitgo.randombytes.RandomBytesPackage;
import com.oblador.keychain.KeychainPackage;
import com.imagepicker.ImagePickerPackage;
import com.mkuczera.RNReactNativeHapticFeedbackPackage;
import com.rnfs.RNFSPackage;
import com.rngoldenkeystore.RNGoldenKeystorePackage;
import com.smixx.fabric.FabricPackage;
import com.learnium.RNDeviceInfo.RNDeviceInfo;

import org.reactnative.camera.RNCameraPackage;

import com.remobile.qrcodeLocalImage.RCTQRCodeLocalImagePackage;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends Application implements ReactApplication, ShareApplication {

    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
            return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
            return Arrays.<ReactPackage>asList(
                    new MainReactPackage(),
            new RNGestureHandlerPackage(),
            new RNMixpanel(),
            new RNViewShotPackage(),
            new RNSharePackage(),
                    new RNShimmerPackage(),
                    new FingerprintAuthPackage(),
                    new SplashScreenReactPackage(),
                    new RandomBytesPackage(),
                    new KeychainPackage(),
                    new ImagePickerPackage(),
                    new RNReactNativeHapticFeedbackPackage(),
                    new RNFSPackage(),
                    new FabricPackage(),
                    new RNDeviceInfo(),
                    new RNCameraPackage(),
                    new RCTQRCodeLocalImagePackage(),
                    new RNGoldenKeystorePackage(),
                    new NotificationManager()
            );
        }

        @Override
        protected String getJSMainModuleName() {
            return "index";
        }
    };

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, /* native exopackage */ false);
    }

    @Override
    public String getFileProviderAuthority() {
        return "io.goldenwallet.provider";
    }
}
