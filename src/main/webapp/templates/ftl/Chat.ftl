<#include "Base.ftl">

<#macro head>
</#macro>

<#macro content>

    <div class="container" style="margin-top: 200px">
                    <#if chatDtoList??>
                        <ul >
                        <#list chatDtoList as chatDto>
                            <li style="display: block">
                                <p style="display: inline-block">${chatDto.getLogin_user()}:</p>
                                <p style="display: inline-block">${chatDto.getText()}</p>
                            </li>
                        </#list >
                        </ul>
                    </#if>
                    <form class="form-box px-3" method="post" action="/login">
                        <input type="text" style="width: 300px">
                        <button type="submit"  class="btn btn-block text-uppercase">Send</button>
                    </form>


    </div>



</#macro>