<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="header-wrap">
				<div class="logo"><a href="/index"><img src="/resources/img/logo.png" alt=""></a></div>
				<div class="login">
                    <c:choose>
                        <c:when test="${empty user }">
        					<ul>
        						<li><a href="/login">Login</a></li>
        						<li><a href="/join">Join</a></li>
        					</ul>
                        </c:when>
                        <c:otherwise>
                            <ul>
                                <li><a href="/logout">Logout</a></li>
                                <li><a href="/cuser">My info</a></li>
                            </ul>
                        </c:otherwise>
                    </c:choose>
				</div>
				<div class="gnb_line"></div>
				<div class="gnb">
					<ul>
						<li>
							ABOUT
							<ul class="sub1">
								<li><a href="/about">한옥숙박체험관</a></li>
							</ul>
						</li>
						<li>
                            ROOMS
                            <ul class="sub2">
                                <li><a href="/room">한옥1호</a></li>
                            </ul>
                        </li>
						<li>
                            SERVICE
                            <ul class="sub3">
                                <li><a href="/service">무인카페</a></li>
                            </ul>
                        </li>
						<li>
                            TOUR
                            <ul class="sub4">
                                <li><a href="/tour">전주한옥마을여행</a></li>
                            </ul>
                        </li>
						<li>
                            RESERVATION
                            <ul class="sub5">
                                <li><a href="/reservation-info">예약안내</a></li>
                                <li><a href="/reservation">실시간예약</a></li>
                            </ul>
                        </li>
						<li>
                            INFO
                            <ul class="sub6">
                                <li><a href="/info">찾아오시는길</a></li>
                            </ul>
                        </li>
						<li>
                            COMMUNITY
                            <ul class="sub7">
                                <li><a href="/community/notice?curPage=1">공지사항</a></li>
                                <li><a href="/community/free?curPage=1">여행후기</a></li>
                            </ul>
                        </li>
					</ul>
				</div>
				<div class="gnb_line"></div>
				<div class="site_info">
					<div class="site_tel">TEL : 010-8669-6700</div>
					<div class="site_tel">Kakaotalk ID : nbtour114</div>
					<div class="site_tel">LINE ID : higasiyama</div>
					<div class="site_bank">신협 010-8669-6700 <br>예금주 : 황미임</div>
					<a href="" class="rev_btn">RESERVATION</a>
				</div>
			</div>