package org.java.dev.controller;

import org.java.dev.entity.Note;
import org.java.dev.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/note")
public class NoteController {
    @Autowired
    NoteService noteService;

    @GetMapping("/")
    public String getStart() {
        return "redirect:/note/list";
    }

    @GetMapping("/list")
    public ModelAndView getNoteList() {
        ModelAndView result = new ModelAndView("note/noteList");
        result.addObject("noteList", noteService.listAll());
        result.addObject("dtoNote", new Note(null, null, null));
        result.addObject("rrr", "priVet");
        return result;
    }

    @PostMapping("/delete")
    public String greetingSubmit(@ModelAttribute Note deleteNote, Model model) {
        noteService.deleteById(deleteNote.getId());
        System.out.println("deleteNote = " + deleteNote);
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public ModelAndView getEditNoteForm(@RequestParam(name = "id") Long id, Model model) {
        ModelAndView result = new ModelAndView("note/noteEdit");

        result.addObject("dtoNote", noteService.getById(id));
        return result;
    }

    @PostMapping("/edit")
    public String editNote(@ModelAttribute Note dtoNote, Model model) {
        ModelAndView result = new ModelAndView("note/noteEdit");
        noteService.update(dtoNote);
        return "redirect:/note/list";
    }

    @PostMapping("/generate")
    public String generateNotes(@ModelAttribute Note dtoNote, Model model) {
        noteService.generateNotes(5);
        return "redirect:/note/list";
    }

    @GetMapping("/new")
    public ModelAndView newNote() {
        ModelAndView result = new ModelAndView("note/noteEdit");
        result.addObject("dtoNote", noteService.add(new Note(null, "Enter note title", "Enter note content")));
        return result;
    }

    @PostMapping("/clean")
    public String deleteAllNotes(Model model) {
        noteService.deleteAll();
        return "redirect:/note/list";
    }
}
