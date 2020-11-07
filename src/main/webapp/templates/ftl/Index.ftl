<#include "Base.ftl">

<#macro head>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@700&family=Raleway:ital,wght@0,400;0,600;1,700&display=swap"
          rel="stylesheet">

</#macro>
<#macro content>

    <div class="intro">
        <div class="container">
            <div class="intro__inner">
                <h1 class="intro__title">Make your life easier
                    with our website</h1>
                <h2 class="intro__subtitle">Money Safe is the best way to keep
                    track of your income and expenses. Don't worry about it.
                    We will do everything for you.</h2>
                <#if name??>

                <#else>
                    <div class="text-center mb-2">
                        Don't have an account?
                        <a href="/registration" class="register-link">Registration</a>
                    </div>
                </#if>
            </div>
        </div>
    </div>

</#macro>


