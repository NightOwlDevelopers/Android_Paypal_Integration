package com.desdev.paypal_integration_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class PaymentDetails extends AppCompatActivity
{
    TextView id, Status, Amount;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        id = findViewById(R.id.txtID);
        Amount = findViewById(R.id.txtAmount);
        Status = findViewById(R.id.txtStatus);

        Intent intent = getIntent();

        try {
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("PaymentDetails"));
            showDetails(jsonObject.getJSONObject("response"), intent.getStringExtra("PaymentAmount"));
        } catch (JSONException e)
        {
            e.printStackTrace();
        }

    }

    private void showDetails(JSONObject response, String paymentAmount)
    {
        try {

            id.setText(response.getString("id"));
            id.setText(response.getString("status"));
            id.setText(response.getString(String.format("$%s", paymentAmount)));
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
    }
}
