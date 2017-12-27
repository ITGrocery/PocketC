package cn.itgrocery.pocketc.ui.login.activity;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rengwuxian.materialedittext.MaterialEditText;

import butterknife.BindView;
import butterknife.BindViews;
import cn.itgrocery.pocketc.R;
import cn.itgrocery.pocketc.base.SimpleActivity;
import cn.itgrocery.pocketc.util.SnackbarUtil;

public class LoginActivity extends SimpleActivity {

    @BindView(R.id.input_phone_number)
    MaterialEditText inputPhoneNumber;
    @BindView(R.id.input_identitfy_code)
    MaterialEditText inputIdentitfyCode;
    @BindView(R.id.get_identitfy_code)
    EditText getIdentitfyCode;

    @BindView(R.id.btn_login)
    Button btnLogin;

    //倒计时
    private CountDownTimer countDownTimer;
    private boolean isCountDown = false;

    @Override
    protected void initEventAndData() {
        countDownTimer = new CountDownTimer(60000,1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                isCountDown = false;
            }
        };

        getIdentitfyCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phoneNumber = inputPhoneNumber.getText().toString();
                String identitfyCode = inputIdentitfyCode.getText().toString();

            }
        });
    }

    @Override
    protected void onViewCreated() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }
}
