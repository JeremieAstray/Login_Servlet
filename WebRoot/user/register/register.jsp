  <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>用户注册页面</title>
<script language="JavaScript" src="register.js" charset="UTF-8" ></script>
<link REL=stylesheet href="register.css" type="text/css">
</head>
<body>
	
	
	<table style="text-align:right;">
	<Form name="form" action="/SanBianYinWu/RegisterServlet" method="post" onSubmit="return checkdata()">
	<tr align="center">
		<td colspan="2" style="font-size: 20px;">用户注册</td>
	</tr>
	<tr>
        <td>用户名（登陆用）*: </td><td><input type="text" name="userName" onBlur="checkUserName(this.value.toLowerCase())"></td>
		<td><div id="usernameErr" class="error"></div></td>
	</tr>	
	<tr>	
		<td>密码*:</td><td><input type="password" name="password" onBlur="checkPassword(this.value)"></td> 
        <td><div id="passwordErr" class="error"></div></td>
    </tr>
    <tr>    
        <td>再输入一次密码*:</td><td><input type="password" name="passwordre" onBlur="checkPasswordre(this.value)"></td>
        <td><div id="passwordErrre" class="error"></div></td>
    </tr>
    <tr>    
        <td>电子邮箱*:</td><td><input type="text" name="email" onBlur="CheckMail(this.value)"></td>
        <td><div id="emailErr" class="error"></div></td>
    </tr>
    <tr>    
        <td>学院*:</td><td><select name="college" onBlur="Checkcollege(this.value)">
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
		<td>年级*:</td><td><select name="year" onBlur="Checkyear(this.value)" id="year">
								<option value="无" >请选择年级</option>
      	 					</select> </td>
      	<script language="JavaScript">creatdate()</script>
        <td><div id="yearErr" class="error"></div></td>
    </tr>
    <tr>    
        <td>专业*:</td><td><input type="text" name="major" onBlur="Checkmajor(this.value)"></td> 
        <td><div id="majorErr" class="error"></div></td>
    </tr>
    <tr>
    	<td colspan="2">以下信息选填</td>
    </tr>
    <tr> 
        <td>学号:</td><td><input type="text" name="studentNum" onBlur="checkstudentNum(this.value.toLowerCase())"></td>
        <td><div id="studentNumErr"></div></td>
    </tr>
    <tr>    
        <td>真实姓名:</td><td><input type="text" name="TrueName"></td>
    </tr>
    <tr>    
        <td>长号电话:</td><td><input type="text" name="longNum" onBlur="Checklongnum(this.value)"></td> 
        <td><div id="longNumErr"></div></td>
    </tr>   
    <tr> 
        <td>短号电话:</td><td><input type="text" name="shortNum" onBlur="Checkshortnum(this.value)"></td>
        <td><div id="shortNumErr"></div></td>
	</tr>
	<tr>
        <td>QQ:</td><td><input type="text" name="qq" onBlur="Checkqq(this.value)"></td>
        <td><div id="qqErr"></div></td>
     </tr>
     <tr>
        <td>宿舍地址:</td><td><textarea name="address" rows="3" cols="18"></textarea></td>
    </tr> 

    <tr>     
		<td colspan="2" align="center"><input type="submit" value="提交" style="float:none;"></td>
	</tr>
	</Form>
		</table>
	
</body>
</html>
