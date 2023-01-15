package com.project.tasks

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.project.tasks.databinding.FragmentTasksBinding

class TasksFragment : Fragment() {
    private var _binding: FragmentTasksBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentTasksBinding.inflate(inflater, container, false)
        val view = binding.root
        Log.d("Here","1")
        val application = requireNotNull(this.activity).application
        Log.d("Here","2")
        val dao = TaskDatabase.getInstance(application).taskDao
        Log.d("Here","3")
        val viewModelFactory = TasksViewModelFactory(dao)
        Log.d("Here","4")
        val viewModel = ViewModelProvider(this, viewModelFactory).get(TasksViewModel::class.java)
        Log.d("Here","5")
        binding.viewModel = viewModel
        Log.d("Here","6")
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}