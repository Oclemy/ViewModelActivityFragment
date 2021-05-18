package info.camposha.viewmodel_activity_fragment

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import info.camposha.viewmodel_activity_fragment.MyFragment.Companion.newInstance

class MainActivity : AppCompatActivity() {
    var myViewModel: MyViewModel? = null
    var handler: Handler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_activity)
        handler = Handler(mainLooper)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, newInstance())
                .commitNow()
        }
        //Make View Holder Object
        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        myViewModel!!.init()
        myViewModel!!.sendData("Hello Johny")

        // Make thread to send data again
        Thread {
            try {
                Thread.sleep(5000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            handler!!.post { myViewModel!!.sendData("How are You ?") }
        }.start()
    }
}