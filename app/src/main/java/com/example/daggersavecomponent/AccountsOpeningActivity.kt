package com.example.daggersavecomponent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import com.example.daggersavecomponent.AccountsOpeningComponent.Companion.getAccountsComponent

class AccountsOpeningActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Log.d("!!hash", this.hashCode().toString())

        Log.d("!!before", getAccountsComponent().hashCode().toString())

        getComponent()
        Log.d("!!onCreate", getAccountsComponent().hashCode().toString())

        val button = findViewById<Button>(R.id.open_button)

        button.setOnClickListener {
            Log.d("!!", "nextActivity")
            val intent = Intent(this, AccountsOpeningActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("!!onStart", getAccountsComponent().hashCode().toString())
    }

    private fun getComponent() {
        AccountsOpeningComponent.init(ApplicationProvider.applicationProviderComponent())
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)

        ApplicationProvider.hashMap[this.hashCode()] = getAccountsComponent()
    }

    override fun onDestroy() {
        if (isFinishing) {
            AccountsOpeningComponent.clear()
            Log.d("!!", "finish")
        }
        super.onDestroy()
    }
}