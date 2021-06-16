package org.d3if4203.assesment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if4203.assesment2.db.CatatanDB

class MainActivity : AppCompatActivity() {
    private val db by lazy { this.let { CatatanDB(it) } }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        CoroutineScope(Dispatchers.IO).launch {
           val catatan = db.catatanDao().getCatatans()
            Log.d("MainActivity", "dbRespons : $catatan")
        }
    }
}