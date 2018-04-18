package com.didispace.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.didispace.dto.ErrorInfo;

@ControllerAdvice
public class GlobalExceptionHandler {

	 @ExceptionHandler(value = Exception.class)
	 public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		 	e.printStackTrace();
	        ModelAndView mav = new ModelAndView();
	        mav.addObject("exception", e);
	        mav.addObject("url", req.getRequestURL());
	        mav.setViewName("error");
	        return mav;
	    }
	 
	    @ExceptionHandler(value = MyException.class)
	    @ResponseBody
	    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, MyException e) throws Exception {
	        ErrorInfo<String> r = new ErrorInfo<>();
	        r.setMessage(e.getMessage());
	        r.setCode(ErrorInfo.ERROR);
	        r.setData("Some Data");
	        r.setUrl(req.getRequestURL().toString());
	        return r;
	    }
	    
	 
	@ExceptionHandler(MultipartException.class)
	public ModelAndView handleError1(MultipartException e,HttpServletRequest req) {
		/*
		 * redirectAttributes.addFlashAttribute("message",
		 * e.getCause().getMessage()); return "redirect:/uploadStatus";
		 */
    	e.printStackTrace();
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("uploaderror");
        return mav;
	}
	
}
