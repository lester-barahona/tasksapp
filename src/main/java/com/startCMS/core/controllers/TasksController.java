package com.startCMS.core.controllers;




import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import com.startCMS.core.models.Task;
import com.startCMS.core.services.TasksService;


@Controller
public class TasksController{
	
    @Autowired
    private TasksService _TasksService;

    @GetMapping({"/",""})
    public String index(){
        return "index";
    }
    
    @GetMapping("/task/create")
    public ModelAndView create() {
    	ModelAndView mv =new ModelAndView("createForm");
    	mv.addObject("task",new Task());
    	return mv;
    }

    @PostMapping("/task/create")
    public String save(@ModelAttribute("task") @Valid Task task, BindingResult bindingResult, RedirectAttributes attributes) {
    	if (bindingResult.hasFieldErrors("name") || bindingResult.hasFieldErrors("description")) {   
            return "createForm";
		}else {
            _TasksService.save(task);
            attributes.addFlashAttribute("message", "Guardado correctamente");
		}
        return "redirect:/task/create";
    }
    
    @DeleteMapping("/task/delete/{id}")
    public RedirectView delete(@PathVariable(name="id",required = true) int id,RedirectAttributes attributes) {
        _TasksService.delete(id);
        return new RedirectView("/task/all");
    }

    @GetMapping("/task/all")
    public ModelAndView allTasks() {
        ModelAndView mv=new ModelAndView("tasksList");
        mv.addObject("list",_TasksService.findAll());
        return mv; 
    }

    @GetMapping("/task/complete")
    public ModelAndView allTasksComplete() {
        ModelAndView mv=new ModelAndView("complete");
        mv.addObject("list",_TasksService.findAll().stream().filter(task->task.isComplete()).collect(Collectors.toList()));
        return mv; 
    }

    @GetMapping("/task/pending")
    public ModelAndView allTasksPending() {
        ModelAndView mv=new ModelAndView("pending");
        mv.addObject("list",_TasksService.findAll().stream().filter(task->!task.isComplete()).collect(Collectors.toList()));
        return mv; 
    }

    @GetMapping("/task/detail/{id}")
    public String taskDetail(@PathVariable int id,Model model) {
        Optional<Task> task=_TasksService.findById(id);
        if(task.isPresent()){
            model.addAttribute("task",task.get());
        }else{
            return "error";
        }
        return "detail";
    }

    @PutMapping("/task/update/{id}")
    public String update(@PathVariable int id,@ModelAttribute("task") @Valid Task task, BindingResult bindingResult, RedirectAttributes attributes) {
    	if (bindingResult.hasFieldErrors("name") || bindingResult.hasFieldErrors("description")) {   
            return "detail";
		}else {
            _TasksService.update(task,id);
            attributes.addFlashAttribute("message", "Actualizado correctamente");
		}
        return "redirect:/task/detail/"+id;
    }
    
    
    //----------------------------------------------------------------------------- IDEAS AND TESTS
    
    // protected String redirectBack(String referer)
    // {
    //     String path=(Objects.nonNull(referer))?referer:"/";
    //     return "redirect:" +path ;
    // }

    // @GetMapping("/task/create")
    // public ModelAndView create() {
    // 	ModelAndView mv =new ModelAndView("createForm");
    // 	 if (!model.containsAttribute("task")) {
    // 			mv.addObject("task",new Task());
    // 	    }
    // 	return mv;
    // }

    // @PostMapping("/task/create")
    // public String save(@ModelAttribute("task") @Valid Task task, BindingResult bindingResult, RedirectAttributes attributes, @RequestHeader String referer) {
    // 	if (bindingResult.hasFieldErrors("name") || bindingResult.hasFieldErrors("description")) {
    //         //attributes.addFlashAttribute("org.springframework.validation.BindingResult.task",bindingResult); //important line, when use dirent route and RedirectView
    //         //attributes.addFlashAttribute("task", task);
    //        // return new RedirectView("/task/create");     
    //         return "createForm";
	// 	}else {
	// 	    //Save here the task
    //         _TasksService.save(task);
    //         attributes.addFlashAttribute("message", "Guardado correctamente");
	// 	}
    //     return "redirect:/task/create";//new RedirectView("/task/create"); // "redirect:/task/create";
    // }

    //redirect back
    //    protected Optional<String> redirectBack(@RequestHeader String referer)
    //    {
    //        return Optional.ofNullable(referer).map(requestUrl -> "redirect:" + requestUrl);
    //    }
}
