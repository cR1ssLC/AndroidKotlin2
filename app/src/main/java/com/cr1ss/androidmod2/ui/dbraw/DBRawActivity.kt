package com.cr1ss.androidmod2.ui.dbraw

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.cr1ss.androidmod2.databinding.ActivityDbrawBinding

class DBRawActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDbrawBinding
    private var counter = 0

    private val vm: DBRawViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDbrawBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            counter++
            binding.tvCounter.text = "$counter"
        }

        binding.btnReduce.setOnClickListener {
            counter--
            binding.tvCounter.text = "$counter"
        }

        vm.progress.observe(this) {

            binding.progressBar.visibility = if (it == 0) View.GONE else View.VISIBLE
            binding.tvProgress.visibility = if (it == 0) View.GONE else View.VISIBLE
            binding.tvProgress.text = "$it"

        }

        binding.btnInsert.setOnClickListener {
            vm.cargaMasiva()
        }

        binding.btnRead.setOnClickListener {
//            val tareas = db.read()
//            Log.e("TAG", "read: $tareas")
        }

        binding.btnUpdate.setOnClickListener {
//            db.update("1", createFakeTarea())
        }
//
        binding.btnDelete.setOnClickListener {
//            db.delete("1")
        }
    }
}


//binding.btnInsert.setOnClickListener {
//    val name = binding.etName.text.toString()
//    val desc = binding.etDesc.text.toString()
//
//    val currentDate = Calendar.getInstance().time
//    val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
//
//    db.insert(
//        TareaModel(
//            name = name,
//            desc = desc,
//            createdAt = formatter.format(currentDate)
//        )
//    )
//}
//
//binding.btnRead.setOnClickListener {
//    val tareas = db.read()
//    Log.e("TAG", "read: $tareas")
//}
//
//binding.btnUpdate.setOnClickListener {
//    val name = binding.etName.text.toString()
//    val desc = binding.etDesc.text.toString()
//    val id = binding.etId.text.toString()
//
//    val currentDate = Calendar.getInstance().time
//    val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
//
//    db.update(
//        id,
//        TareaModel(name = name, desc = desc, createdAt = formatter.format(currentDate))
//    )
//}
////
//binding.btnDelete.setOnClickListener {
//    val id = binding.etId.text.toString()
//    db.delete(id)
//}