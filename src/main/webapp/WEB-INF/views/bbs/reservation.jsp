<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>reservation</title>
    <link rel="stylesheet" type="text/css" href="/resources/bbs2/css/common.css">
    <link rel="stylesheet" type="text/css" href="/resources/bbs2/css/reservation.css">
    <link rel="stylesheet" type="text/css" href="/resources/bbs2/css/fullcalendar.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/bbs2/css/fullcalendar.print.css">
    <script type="text/javascript" src="/resources/bbs2/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="/resources/bbs2/js/common.js"></script>
    <script type="text/javascript" src="/resources/bbs2/js/moment.min.js"></script>
    <script type="text/javascript" src="/resources/bbs2/js/fullcalendar.min.js"></script>
    <script type="text/javascript" src="/resources/bbs2/js/locale-all.js"></script>
    <script type="text/javascript">
    $(document).ready(function() {
        $("#calender").fullCalendar({
              defaultDate : "2016-05-12"
            , lang : "ko"
            , editable : true
            , eventLimit : true
            , events: [
                {
                      title : "All Day Event"
                    , start : "2016-05-01"
                },
                {
                      title : "Long Event"
                    , start : "2016-05-07"
                    , end : "2016-05-10"
                },
                {
                      id : 999
                    , title : "Repeating Event"
                    , start : "2016-05-09T16:00:00"
                },
                {
                      id : 999
                    , title : "Repeating Event"
                    , start : "2016-05-16T16:00:00"
                },
                {
                      title : "Conference"
                    , start : "2016-05-11"
                    , end : "2016-05-13"
                },
                {
                      title : "Meeting"
                    , start : "2016-05-12T10:30:00"
                    , end : "2016-05-12T12:30:00"
                },
                {
                      title : "Lunch"
                    , start : "2016-05-12T12:00:00"
                },
                {
                      title : "Meeting"
                    , start : "2016-05-12T14:30:00"
                },
                {
                      title : "Happy Hour"
                    , start : "2016-05-12T17:30:00"
                },
                {
                      title : "Dinner"
                    , start : "2016-05-12T20:00:00"
                },
                {
                      title : "Birthday Party"
                    , start : "2016-05-13T07:00:00"
                },
                {
                      title : "Click for Google"
                    , url : "http://google.com/"
                    , start : "2016-05-28"
                }
            ]
        });
    });
</script>
</head>
<body>
    <div class="wrap">
        <div class="header"><%@ include file="guide/header.jsp" %></div>
        <div class="content">
            <div class="section1">
                <img src="/resources/bbs2/img/mainTypo01.png" alt="" class="main_tp">
                <ul>
                    <li><a href="javascript:void(0)"><img src="/resources/bbs2/img/about01_bg.jpg" alt=""></a></li>
                </ul>
                <div class="slider_line1"></div>
            </div>
            <div class="section2">
                <div class="subtitle">
                    <span class="text1">전주한옥숙박체험관 </span><br>
                    <h2>RESERVATION</h2>
                </div>
                <div class="line"></div>
                <div id="calender"></div>
            </div>
        </div>
        <div class="footer"><%@ include file="guide/footer.jsp" %></div>
    </div>
</body>
</html>