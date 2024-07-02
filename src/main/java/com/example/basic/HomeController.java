package com.example.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

// @Controller 의미
// 개발자가 스프링부트에게 말한다
// 아래 있는 Homecontroller는 컨트롤러이다.
@Controller

public class HomeController {

    private int count;

    public HomeController() {
        count = -1;
    }

    // @GetMapping("/home/main") 의미
    // 개발자가 스프링부트에게 말한다
    // 만약에 /home/main 이런 요청이 들어 오면 아래 메서드를 실행해줘
    @GetMapping("/home/main")

    // @ResponseBody 의미
    // 아래 메서드를 실행한 후 그 리턴값을 응답으로 삼아줘
    @ResponseBody
    public String showHome() {
        return "안녕하세요.";
    }

    @GetMapping("/home/main2")
    @ResponseBody
    public String showHome2() {
        return "환영합니다.";
    }

    @GetMapping("/home/main3")
    @ResponseBody
    public String showHome3() {
        return "스프링부트는 획기적이다.";
    }

    @GetMapping("/home/increase")
    @ResponseBody
    public int showIncrease() {
        count++;
        return count;
    }

    @GetMapping("/home/plus")
    @ResponseBody
    // RequestParam의 의미
    // 개발자가 스프링부트에게 말한다.
    // int a 는 쿼리스트링에서 a파라미터의 값을 얻은 후 정수화 한 값이어야 한다.
    // @RequestParam은 생략 가능
    public int showPlus(@RequestParam(value = "a", defaultValue = "0") int a,
                        @RequestParam(value = "a", defaultValue = "0") int b)
    {
        return a + b;
    }

    @GetMapping("/home/returnboolean")
    @ResponseBody
    public boolean showBoolean() {
        return true;
    }

    @GetMapping("/home/returnDouble")
    @ResponseBody
    public double showDouble() {
        return Math.PI;
    }

    @GetMapping("/home/returnIntList")
    @ResponseBody
    public List<Integer> showIntArray() {
        List<Integer> list = new ArrayList<>() {{
            add(10);
            add(20);
            add(30);
        }};

        return list;
    }

    @GetMapping("/home/returnMap")
    @ResponseBody
    public Map<String, Object> showReturnMap() {
        Map<String, Object> map = new LinkedHashMap<>() {{
            put("id", 1);
            put("speed", 100);
            put("name", "아반떼");
            put("relatedIds", new ArrayList<>() {{
                add(1);
                add(2);
                add(3);
            }});
        }};

        return map;
    }

    @GetMapping("/home/returnCar")
    @ResponseBody
    public Car showReturnCar() {
        Car car = new Car(1, 100, "에쿠스", new ArrayList<>() {{
            add(10);
            add(20);
            add(30);
        }});

        // getter를 만들어줘야 객체를 보여줄 수 있다.
        return car;
    }

//    @GetMapping("/home/returnCar2")
//    @ResponseBody
//    public Car2 showReturnCar2() {
//        Car2 car2 = new Car2(1, 100, "에쿠스", new ArrayList<>() {{
//            add(10);
//            add(20);
//            add(30);
//        }});
//
//        // getter를 만들어줘야 객체를 보여줄 수 있다.
//        return car2;
//    }

    @GetMapping("/home/returnCarMapList")
    @ResponseBody
    public List<Map<String, Object>> showReturnCarMapList() {

        Map<String, Object> carMap1 = new LinkedHashMap<>() {{
            put("id", 1);
            put("speed", 100);
            put("name", "아반떼");
            put("relatedIds", new ArrayList<>() {{
                add(1);
                add(2);
                add(3);
            }});
        }};

        Map<String, Object> carMap2 = new LinkedHashMap<>() {{
            put("id", 2);
            put("speed", 200);
            put("name", "각쿠스");
            put("relatedIds", new ArrayList<>() {{
                add(5);
                add(6);
                add(7);
            }});
        }};

        List<Map<String, Object>> list = new ArrayList<>();

        list.add(carMap1);
        list.add(carMap2);

        return list;
    }

}

class Car {
    private final int id;
    private final int speed;
    private final String name;
    private final List<Integer> relatedIds;

    public Car(int id, int speed, String name, List<Integer> relatedIds) {
        this.id = id;
        this.speed = speed;
        this.name = name;
        this.relatedIds = relatedIds;
    }

    public int getId() {
        return id;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getRelatedIds() {
        return relatedIds;
    }
}

//    @AllArgsConstructor
//    @Getter
//    class Car2 {
//        private final int id;
//        private final int speed;
//        private final String name;
//        private final List<Integer> relatedIds;
//
//    }
