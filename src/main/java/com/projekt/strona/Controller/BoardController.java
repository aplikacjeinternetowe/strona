package com.projekt.strona.Controller;

import com.projekt.strona.Service.BoardService;
import com.projekt.strona.Service.ImageService;
import com.projekt.strona.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

@Controller
public class BoardController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private BoardService boardService;

    @Autowired
    private UserService userService;

    @Autowired
    private ServletContext context;

    @RequestMapping(value = "/")
    public String showIndex(){
        return "index";
    }

    @RequestMapping(value = "/add_item")
    public String addItemPanel(){
        return "add_item";
    }

    @RequestMapping(value = "/add_item",method = RequestMethod.POST)
    public String addItem(@RequestParam(value = "item_name",defaultValue = " ") String itemName,
                          @RequestParam(value = "item_description",defaultValue = " ") String itemDescription,
                          @RequestParam(value = "item_price",defaultValue = " ") String itemPrice,
                          @RequestParam(value = "user_name",defaultValue = " ") String userName,
                          @RequestParam(value = "image_list",defaultValue = " ") String imageList) {



            boardService.addItem(itemName, itemDescription, itemPrice, userName);

            if (!(imageList.equals(" "))) {
                String[] imgList = imageList.split("https");
                System.out.println("dlugosc przed:" + imgList.length);
                for (int i = 1; i < imgList.length; i++) {
                    System.out.println(imgList[i]);
                    imgList[i] = "https".concat(imgList[i]);
                    System.out.println(imgList[i]);
                }
                System.out.println("dlugosc po:" + imgList.length);
                int itemId = boardService.getMaxItemId();
                imageService.addImageLinkToDatabase(imgList,itemId);

            }


            String redirectUrl = "/show_items";
            return "redirect:" + redirectUrl;

    }


    @RequestMapping(value = "/show_items", method = RequestMethod.GET)
    public String showItems(Model model){
        model.addAttribute("itemList",boardService.showItems());
        return "show_items";
    }


    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public String showSingleItem(@PathVariable("id") int id, Model model){
        model.addAttribute("item_description",boardService.showItemDescription(id));
        model.addAttribute("phone_number",userService.getUserPhoneNumberByItemId(id));
        return "show_single_item";
    }

}
