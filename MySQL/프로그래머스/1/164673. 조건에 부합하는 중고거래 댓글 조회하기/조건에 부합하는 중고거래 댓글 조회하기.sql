-- 코드를 입력하세요
SELECT u.TITLE ,u.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.CONTENTS, 
DATE_FORMAT(r.created_date, '%Y-%m-%d') as CREATED_DATE
from USED_GOODS_BOARD u
inner join USED_GOODS_REPLY r on u.BOARD_ID = r.BOARD_ID
where (u.created_date between '2022-10-01' and '2022-10-31') 
order by r.created_date asc, u.title asc
;