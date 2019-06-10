package com.example.myapplication.controller;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageController {
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String getPage()
	{
		return "uploadView";
	}
	
	@RequestMapping(value="/upload",method = RequestMethod.POST)
	public String uploadImage(@RequestParam("file") MultipartFile file, Model model) throws IOException
	{
		if(!file.isEmpty())
		{
			FileOutputStream fout=new FileOutputStream("D:\\policy nepal\\uploadImage\\src\\main\\resources\\imgs\\"+file.getOriginalFilename());
			
			fout.write(file.getBytes());
			fout.close();
			model.addAttribute("msg", "upload Success !!");
			
		}
		return "uploadSuccess";
	}

}
