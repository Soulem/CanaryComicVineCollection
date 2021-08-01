package com.example.canarycomicvinecollection.model.data.comicvineaapi.issue

import com.example.canarycomicvinecollection.model.data.comicvineaapi.Result
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

data class Issue(
    val aliases: @RawValue Any,
    val api_detail_url: String,
    val character_credits: List<CharacterCredit>,
    val character_died_in: @RawValue List<Any>,
    val concept_credits: List<ConceptCredit>,
    val cover_date: String,
    val date_added: String,
    val date_last_updated: String,
    val deck: String,
    val description: String,
    val first_appearance_characters: @RawValue Any,
    val first_appearance_concepts: @RawValue Any,
    val first_appearance_locations: @RawValue Any,
    val first_appearance_objects: @RawValue Any,
    val first_appearance_storyarcs: @RawValue Any,
    val first_appearance_teams: @RawValue Any,
    val has_staff_review: Boolean,
    val id: Int,
    val image: Image,
    val issue_number: String,
    val location_credits: @RawValue List<Any>,
    val name: String,
    val object_credits: @RawValue List<Any>,
    val person_credits: List<PersonCredit>,
    val site_detail_url: String,
    val store_date: String,
    val story_arc_credits: @RawValue List<Any>,
    val team_credits: @RawValue List<Any>,
    val team_disbanded_in: @RawValue List<Any>,
    val volume: Volume
):Result()