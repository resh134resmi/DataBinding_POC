package com.litmus7.databindingsample

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.litmus7.databindingsample.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bindings: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        var product = Product(1, "Blue diamond ring", 200, "Gorgeous Ring")
        bindings.product = product
        // bindings.product?.name?.set("Resmi")

        var handlers = MyClickHandlers(this);
        bindings.content.handlers = handlers


    }


    class MyClickHandlers(var context: Context) {


        fun onButtonClickWithParam(view: View, product: Product) {

            Toast.makeText(context, "Name: " + product.name, Toast.LENGTH_SHORT)
                .show()
        }
    }

    class BindingUtils {
        fun capitalize(text: String): String {

            return text.toUpperCase()
        }

    }

}

