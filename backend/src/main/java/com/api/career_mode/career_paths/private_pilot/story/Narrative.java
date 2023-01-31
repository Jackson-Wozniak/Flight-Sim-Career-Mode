package com.api.career_mode.career_paths.private_pilot.story;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
Entity that will carry the outlines of story explanations from text files.
Saved default narratives will include variables shown as {varName} included in story
    that can be replaced with desired value before being displayed to user.
To find the narrative again, go to the text file based on the cargo name, and skip to the line saved
    in lineNumberInFile variable
 */
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Narrative {

    @Column(name = "cargo_name")
    private String relatedCargoName;

    @Column(name = "line_number_in_file")
    //variable that saves the line the narrative was found in text file, allowing for easy storage later using the relatedCargoName
    private long lineNumberInFile;
}
