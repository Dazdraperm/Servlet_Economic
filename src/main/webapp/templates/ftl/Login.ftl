<#include "Base.ftl">

<#macro head>
    <link rel="stylesheet" href="templates/ftl/css/style.css">
</#macro>

<#macro content>

    <div class="container">
        <div class="row px-3">
            <div class="col-lg-5 col-xl-5 card flex-row mx-auto px-0">
                <div class="card-body">
                    <h4 class="title text-center mt-4">Login to your account</h4>
                    <form class="form-box px-3" method="post" action="/login">
                        <div class="form-input">
                            <span><i class="fa fa-envelope-o"></i></span>
                            <input type="login" name="email" placeholder="Email" tabindex="10" required>
                        </div>
                        <div class="form-input">
                            <span><i class="fa fa-key"></i></span>
                            <input type="password" name="password" placeholder="Password" required>
                        </div>

                        <div class="mb-3">
                            <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="cb1" name="">
                                <label class="custom-control-label" for="cb1">Remember me</label>
                            </div>
                        </div>

                        <div class="mb-3" style="margin-left: -75px">
                            <button type="submit"  class="btn btn-block text-uppercase">Login</button>
                        </div>

                        <hr class="my-4">


                    </form>
                    <div class="text-center mb-2">
                        Don't have an account?
                        <a href="/registration" class="register-link">Registration</a>
                    </div>
                </div>
            </div>
        </div>
    </div>



</#macro>