<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0,user-scalable=0">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta charset="UTF-8">
</head>
<body>
login login2
<a href="/authorize/login">login</a><br>

<body class="bg-info">

<div style="margin-top: 180px;" class="visible-lg-block"></div>
<div style="margin-top: 100px;" class="visible-md-block "></div>
<div style="margin-top: 10px;" class="visible-ms-block"></div>
<div style="margin-top: 5px;" class="visible-xs-block "></div>

<div class="container">
    <div class="row">
        <div class="col-sm-4 col-xs-1"></div>
        <form action="/authorize/login" method="post"
              class="col-sm-4 col-xs-11  bg-info " id="form"
              autocomplete="off" style="padding :20px">

            <div class="input-error text-danger">
            ${message!}
            </div>
            <div class="form-group form-group-lg">

                <label class="control-label " for="account">
                <@spring.message "label.account"/>
                </label>

                <div class="input-group ">
						<span class="input-group-addon "> <span
                                class="glyphicon glyphicon-user"></span>

						</span>
                    <input pattern="^[\w]{3,12}$" required="required" name="account"
                           class="form-control input-lg" id="account"
                           placeholder="<@spring.message code=" tip.account.placeholder" />"
                           value="${criteria.account! }"
                    />
                    <span class="glyphicon  form-control-feedback"
                          aria-hidden="true"></span>

                </div>
                <div class="input-error text-danger">

                </div>

            </div>
            <div class="form-group form-group-lg">
                <label class="control-label " for="password">
                <@spring.message
                            code="label.password"/>
                </label>
                <div class="input-group ">
						<span class="input-group-addon "> <span
                                class="glyphicon glyphicon-lock"></span></span>


                    <input
                            pattern="^[\w]{3,12}$" required="required" type="password"
                            name="password" class="form-control " id="password"
                            value="${criteria.account! }"
                            placeholder="<@spring.message code=" tip.password.placeholder" />"/>
                    <span class="glyphicon  form-control-feedback"
                          aria-hidden="true"></span>

                </div>

                <div class="input-error text-danger">

                </div>
            </div>


            <div class="form-group">
                <button class="form-control btn btn-success input-lg btn-lg" type="submit">
                <@spring.message  code="button.login"/>
                </button>

            </div>
            <div class="row text-muted">
                    	<span class="col-xs-12 col-sm-12 col-md-12 col-lg-6">
                    	<form:checkbox path="remember"/>

                   	  	<label for="remember"
                               onclick="$('#remember1').click()"
                        ><small><@spring.message  code="label.remember"/></small></label>
                        </span>

            </div>
        </form>

    </div>
</div>

</body>
</html>