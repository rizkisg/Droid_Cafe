package lat.pam.droidcafe

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class OrderActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        // Inisialisasi Spinner
        val spinner: Spinner = findViewById(R.id.City_spinner)
        // Buat ArrayAdapter menggunakan string array dan layout spinner default
        ArrayAdapter.createFromResource(
            this,
            R.array.City_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Tentukan layout yang akan digunakan saat pilihan muncul
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Terapkan adapter ke spinner
            spinner.adapter = adapter
        }

        // Set listener untuk item yang dipilih
        spinner.onItemSelectedListener = this
    }



    fun onRadioButtonClicked(view: View) {
        // Is the button now checked?
        val checked = (view as RadioButton).isChecked
        when (view.getId()) {
            R.id.sameday -> if (checked) // Same day service
                displayToast(getString(R.string.same_day_messenger_service))


            R.id.nextday -> if (checked) // Next day delivery
                displayToast(getString(R.string.next_day_ground_delivery))


            R.id.pickup -> if (checked) // Pick up
                displayToast(getString(R.string.pick_up))


            else -> {}
        }
    }


    private fun displayToast(message: String) {
        Toast.makeText(
            applicationContext, message,
            Toast.LENGTH_SHORT
        ).show()
    }

    // Implementasi SpinnerActivity
    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        // Sebuah item dipilih, Anda dapat mengambil item yang dipilih dengan menggunakan
        // parent.getItemAtPosition(pos)
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Callback lain saat tidak ada yang dipilih
    }
}
