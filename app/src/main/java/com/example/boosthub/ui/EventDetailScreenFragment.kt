package com.example.boosthub.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.boosthub.MainViewModel
import com.example.boosthub.databinding.FragmentEventDetailScreenBinding

class EventDetailScreenFragment : Fragment() {

    // The binding object for the fragment and the ViewModel are declared, the arguments passed are also picked up.
    private lateinit var binding: FragmentEventDetailScreenBinding
    private val viewModel: MainViewModel by activityViewModels()
    private val args: EventDetailScreenFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEventDetailScreenBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Gets the data and inserts it into the corresponding views.
        binding.eventDetailImageSIV.load(args.image)
        binding.eventDetailWhatsUpInputMTV.text = args.whatsUp
        binding.eventDetailLocationInputMTV.text = args.location
        binding.eventDetailDateInputMTV.text = args.date
        binding.eventDetailWhosThereInputMTV.text = args.whosThere
        binding.eventDetailWhatElseInputMTV.text = args.whatElse
        binding.eventDetailRestrictionsInputMTV.text = args.restrictions

        var intentString = ""
        val searchterm = ""

        // Observes location data changes and updates map navigation intent.
        viewModel.location.observe(viewLifecycleOwner) {

            val dataset = it[0]

            val lat = dataset.lat
            val lon = dataset.lon

            intentString = ("geo:$lat,$lon?q=$searchterm")
        }

        // Gets the location data for the specified event.
        viewModel.getLocation(args.location)

        // Opens Google Maps with the destination location when the Location TextView is clicked.
        binding.eventDetailLocationInputMTV.setOnClickListener {

            val gmmIntentUri = Uri.parse(intentString)

            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)

            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
    }
}
