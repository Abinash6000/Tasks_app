package com.project.tasks

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.project.tasks.databinding.FragmentTasksBinding

class TasksFragment : Fragment() {
    private var _binding: FragmentTasksBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentTasksBinding.inflate(inflater, container, false)
        val view = binding.root
        val application = requireNotNull(this.activity).application
        val dao = TaskDatabase.getInstance(application).taskDao
        val viewModelFactory = TasksViewModelFactory(dao)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(TasksViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = TaskItemAdapter()
        binding.tasksList.adapter = adapter

        viewModel.tasks.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}