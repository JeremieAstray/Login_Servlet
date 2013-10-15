<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员专用注册页面</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script language="JavaScript" src="adminRegister.js" charset="UTF-8" ></script>
  <link REL=stylesheet href="adminRegister.css" type="text/css">
  <body >
	  <Form name="form" action="/SanBianYinWu/adminRegisterServlet" method="post" onSubmit="return checkdata()">
		<table style="text-align:right;">
	<tr align="center">
		<td colspan="2" style="font-size: 20px;">管理员注册</td>
	</tr>
	<tr>
        <td>管理员名（登陆用）: </td><td><input type="text" name="adminName" onBlur="checkadminName(this.value.toLowerCase())"></td>
		<td><div id="adminNameErr" class="error"></div></td>
	</tr>	
	<tr>	
		<td>密码:</td><td><input type="password" name="password" onBlur="checkPassword(this.value)"></td> 
        <td><div id="passwordErr" class="error"></div></td>
    </tr>
    <tr>    
        <td>再输入一次密码:</td><td><input type="password" name="passwordre" onBlur="checkPasswordre(this.value)"></td>
        <td><div id="passwordreErr" class="error"></div></td>
    </tr>
    <tr>    
        <td>电子邮箱:</td><td><input type="text" name="email" onBlur="CheckMail(this.value)"></td>
        <td><div id="emailErr" class="error"></div></td>
    </tr>
    <tr>    
        <td>学院:</td><td><select name="college" onBlur="Checkcollege(this.value)">
			<option value="无" >学院设置</option> 
			<option value="农学院">农学院</option>
			<option value="资源环境学院">资源环境学院</option>
			<option value="生命科学学院">生命科学学院</option>
			<option value="经济管理学院">经济管理学院</option>
			<option value="工程学院">工程学院</option>
			<option value="动物科学学院">动物科学学院</option>
			<option value="兽医学院 ">兽医学院</option>
			<option value="园艺学院">园艺学院</option>
			<option value="食品学院">食品学院</option>
			<option value="林学院">林学院</option>
			<option value="人文与法学学院">人文与法学学院</option>
			<option value="理学院">理学院</option>
			<option value="信息学院">信息学院</option>
			<option value="软件学院">软件学院</option>
			<option value="艺术学院">艺术学院</option>
			<option value="外国语学院">外国语学院</option>
			<option value="水利与土木工程学院">水利与土木工程学院</option>
			<option value="公共管理学院">公共管理学院</option>
			<option value="继续教育学院">继续教育学院</option>
			<option value="国际教育学院">国际教育学院</option>
		</select></td> 
         <td><div id="collegeErr" class="error"></div></td>
    </tr>    
    <tr>
		<td>年级:</td><td><select name="year" onBlur="Checkyear(this.value)" id="year">
								<option value="" >请选择年级</option>
      	 					</select> </td>
      	<script language="JavaScript">createdate()</script>
        <td><div id="yearErr"  class="error"></div></td>
    </tr>
    <tr>    
        <td>专业:</td><td><input type="text" name="major" onBlur="Checkmajor(this.value)"></td> 
        <td><div id="majorErr" class="error"></div></td>
    </tr>
    <tr>    
        <td>真实姓名:</td><td><input type="text" name="TrueName" onBlur="checkTrueName(this.value)"></td><td><div id="TrueNameErr" class="error"></div></td>
    </tr>
    <tr>    
        <td>长号电话:</td><td><input type="text" name="longNum" onBlur="Checklongnum(this.value)"></td> 
        <td><div id="longNumErr" class="error"></div></td>
    </tr>   
    <tr>
        <td>短号电话:</td><td><input type="text" name="shortNum" onBlur="Checkshortnum(this.value)"></td>
        <td><div id="shortNumErr" class="error"></div></td>
	</tr>
	<tr>
        <td>QQ:</td><td><input type="text" name="qq" onBlur="Checkqq(this.value)"></td>
        <td><div id="qqErr" class="error"></div></td>
     </tr>
     <tr>
        <td>宿舍地址:</td><td><textarea name="address" rows="3" cols="18" onBlur="checkaddress(this.value)"></textarea></td>
        <td><div id="addressErr" class="error"></div></td>
    </tr> 
	<tr><td>管理员权限:</td>
			<td class="radio" colspan="2"><input type="radio"name="adminRight" value="1"checked class="radio" >市场专员
    		<input type="radio"name="adminRight" value="2" class="radio">客服<br>
    		<input type="radio"name="adminRight" value="3" class="radio" >超级管理员 </td>
    </tr>		
    <tr>     
		<td colspan="2" align="center"><input type="submit" value="提交" style="float:none;"></td>
	</tr>
			
</table>
	  </Form>
  </body>
</html>
