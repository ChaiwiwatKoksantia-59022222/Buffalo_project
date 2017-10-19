package com.example.melonchan.buffalo_project.tools;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by android on 9/28/2017 AD.
 */

public class Calculator {

    private static Calendar calendar;

    Integer day, year, month, cycle;

    public Calculator(Integer day, Integer month, Integer year, Integer cycle) {

        this.day = day;
        this.month = month;
        this.year = year;
        this.cycle = cycle;

        //Log.e("TEST",String.valueOf(day)+String.valueOf(month)+String.valueOf(year)+String.valueOf(cycle));
        calendar = new Calendar(day, month, year, cycle);

    }

    public ArrayList<String> getDate() {
        return zipAllDate();
    }

    private ArrayList<String> zipAllDate() {
        ArrayList<String> arrayList = new ArrayList<>();

        convert_array ca1 = new convert_array(calendar.getA1_array());
        arrayList.add(convert(ca1));

        convert_array ca2 = new convert_array(calendar.getA2_array());
        arrayList.add(convert(ca2));

        convert_array ca3 = new convert_array(calendar.getB1_array());
        arrayList.add(convert(ca3));

        convert_array ca4 = new convert_array(calendar.getB2_array());
        arrayList.add(convert(ca4));

        convert_array ca5 = new convert_array(calendar.getB3_array());
        arrayList.add(convert(ca5));

        return arrayList;
    }

    private String convert(convert_array convert_array) {
        com.example.melonchan.buffalo_project.tools.Calendar_Tools calendar_tools = new com.example.melonchan.buffalo_project.tools.Calendar_Tools();
        return "วันที่ " + String.valueOf(convert_array.getDay()) + " " + calendar_tools.convertMonth_intToName(convert_array.getMonth()) + " พ.ศ." + String.valueOf(convert_array.getYear());
    }

    static class Calendar {

        private Integer day, month, year, cycle, a1_day, a1_month, a1_year, a2_day, a2_month, a2_year;
        private Integer b1_d, b1_m, b1_y, b2_d, b2_m, b2_y, b3_d, b3_m, b3_y;
        private Calendar_Tools ct_1, ct_2, ct_3, ct_4, ct_5;

        public Calendar(Integer day, Integer month, Integer year, Integer cycle) {
            this.day = day;
            this.month = month;
            this.year = year;
            this.cycle = cycle;

            calculate_a1();
            calculate_a2();
            calculate_b1();
            calculate_b2();
            calculate_b3();
        }

        public Integer[] getA1_array() {
            return ct_1.getAction_day();
        }

        private void calculate_a1() {
            ct_1 = new Calendar_Tools(day, month, year);
            convert_array convert_array = new convert_array(ct_1.setAction_day(cycle, false));
            a1_day = convert_array.getDay();
            a1_month = convert_array.getMonth();
            a1_year = convert_array.getYear();
        }

        public Integer[] getA2_array() {
            return ct_2.getAction_day();
        }

        private void calculate_a2() {
            ct_2 = new Calendar_Tools(day, month, year);
            convert_array convert_array = new convert_array(ct_2.setAction_day(295 + cycle, false));
            a2_day = convert_array.getDay();
            a2_month = convert_array.getMonth();
            a2_year = convert_array.getYear();
        }

        public Integer[] getB1_array() {
            return ct_3.getAction_month();
        }

        private void calculate_b1() {
            ct_3 = new Calendar_Tools(a1_day, a1_month, a1_year);
            convert_array convert_array = new convert_array(ct_3.setAction_month(10));
            b1_d = convert_array.getDay();
            b1_m = convert_array.getMonth();
            b1_y = convert_array.getYear();
        }

        public Integer[] getB2_array() {
            return ct_4.getAction_day();
        }

        private void calculate_b2() {
            ct_4 = new Calendar_Tools(b1_d, b1_m, b1_y);
            convert_array convert_array = new convert_array(ct_4.setAction_day(15, false));
            b2_d = convert_array.getDay();
            b2_m = convert_array.getMonth();
            b2_y = convert_array.getYear();
        }

        public Integer[] getB3_array() {
            return ct_5.getAction_day();
        }

        private void calculate_b3() {
            ct_5 = new Calendar_Tools(b2_d, b2_m, b2_y);
            convert_array convert_array = new convert_array(ct_5.setAction_day(cycle, true));
            b3_d = convert_array.getDay();
            b3_m = convert_array.getMonth();
            b3_y = convert_array.getYear();
        }

    }

    static class convert_array {
        Integer day, month, year;

        public convert_array(Integer[] array) {
            this.day = array[0];
            this.month = array[1];
            this.year = array[2];
        }

        public Integer getDay() {
            return day;
        }

        public Integer getMonth() {
            return month;
        }

        public Integer getYear() {
            return year;
        }
    }

    static class Calendar_Tools {

        private Integer[] date;
        private Integer day, month, year, action_day, action_month;

        public Calendar_Tools(Integer day, Integer month, Integer year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }

        public Integer[] getDate() {
            return date;
        }

        public Integer[] getAction_day() {
            return date;
        }

        public Integer[] getAction_month() {
            return date;
        }

        public Integer[] setAction_month(Integer action_month) {
            Integer[] date = new Integer[3];

            Integer d1 = day;
            Integer m_t = month + action_month;
            Integer y1 = year;

            while (m_t > 12) {
                y1 = y1 + 1;
                m_t = m_t - 12;
            }

            date[0] = d1;
            date[1] = m_t;
            date[2] = y1;

            this.date = date;

            return date;
        }

        public Integer[] setAction_day(Integer action_day, Boolean menus) {
            Integer[] date;

            if (menus) {
                date = cal_menus(action_day);
            } else {
                date = cal_plus(action_day);
            }

            this.date = date;

            return date;
        }

        private Integer[] cal_plus(Integer action_day) {
            Integer[] date = new Integer[3];
            Integer d_t = day + action_day;
            Integer m1 = month;
            Integer y1 = year;

            Integer m2 = getMonthDay(m1, y1);

            while (d_t > m2) {
                m2 = getMonthDay(m1, y1);
                m1 = m1 + 1;
                d_t = d_t - m2;
                if (m1 > 12) {
                    m1 = m1 - 12;
                    y1 = y1 + 1;
                }
            }

            date[0] = d_t;
            date[1] = m1;
            date[2] = y1;
            return date;
        }

        private Integer[] cal_menus(Integer action_day) {
            Integer[] date = new Integer[3];
            Integer d_t = day - action_day;
            Integer m1 = month;
            Integer y1 = year;

            Integer md1 = m1 - 1;
            if (md1 < 1) {
                md1 = m1 + 12;
            }
            Integer m2 = getMonthDay(md1, y1);

            while (d_t < 0) {
                Log.e("DAY", String.valueOf(d_t));
                Log.e("MONTH", String.valueOf(m1));
                Log.e("YEAR", String.valueOf(y1));

                m1 = m1 - 1;
                if (m1 < 1) {
                    m1 = m1 + 12;
                    y1 = y1 - 1;
                }
                m2 = getMonthDay(m1, y1);
                d_t = d_t + m2;


            }

            date[0] = d_t;
            date[1] = m1;
            date[2] = y1;
            return date;

        }

        private Boolean check_year(Integer year) {
            Boolean x = false;
            if ((year - 2000) % 4 == 0) {
                x = true;
            }
            return x;
        }

        private Integer getMonthDay(Integer month, Integer year) {
            Integer Month_day = 0;
            Boolean four_year = check_year(year);
            switch (month) {
                case 1:
                    Month_day = 31;
                    break;
                case 2:
                    Month_day = return_day(four_year);
                    break;
                case 3:
                    Month_day = 31;
                    break;
                case 4:
                    Month_day = 30;
                    break;
                case 5:
                    Month_day = 31;
                    break;
                case 6:
                    Month_day = 30;
                    break;
                case 7:
                    Month_day = 31;
                    break;
                case 8:
                    Month_day = 31;
                    break;
                case 9:
                    Month_day = 30;
                    break;
                case 10:
                    Month_day = 31;
                    break;
                case 11:
                    Month_day = 30;
                    break;
                case 12:
                    Month_day = 31;
                    break;
                default:
                    Month_day -= 10000;
                    break;
            }
            return Month_day;
        }

        private Integer return_day(Boolean x) {
            Integer y = 0;
            if (x) {
                y = 29;
            } else {
                y = 28;
            }
            return y;
        }

    }


}
