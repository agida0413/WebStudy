<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vertical Sliding</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function() {
  let itemHeight = $('.item').outerHeight();
  let currentIndex = 0;
  let slideCount = 0;

  function slideItems() {
    currentIndex = (currentIndex + 3) % 9;
    slideCount++;

    if (slideCount === 4) { // 3번의 변경 이후 4번째 변경에서 처음으로 돌아감
      $('.items').animate({ top: 0 }, 1000); // 첫 아이템으로 내려오게 함
      currentIndex = 0;
      slideCount = 0;
    } else {
      $('.items').animate({ top: -currentIndex * itemHeight }, 1000);
    }
  }

  setInterval(slideItems, 2000);
});
</script>

<style>
.slider {
  height: 300px; /* 세로 슬라이드 창 높이 */
  overflow: hidden; /* 초과된 부분 숨김 */
}

.items {
  position: relative; /* 상대 위치 지정 */
}

.item {
  height: 100px; /* 각각의 아이템 높이 */
  border: 1px black solid; /* 테두리 스타일 */
}
</style>
</head>
<body>
  <div class="slider">
    <div class="items">
      <c:forEach var="i" begin="1" end="9">
        <div class="item">${i}</div>
      </c:forEach>
    </div>
  </div>
</body>
</html>