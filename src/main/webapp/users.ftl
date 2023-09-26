<html lang="en">
<#include "base.ftl">


<#macro title>Users</#macro>
<#macro header>Users</#macro>


<#macro content>
    Hello,
    <br>
    <#if users??>
        <#list users as u>
            ${u.firstname} ${u.lastname}
            <br>
        </#list>
    </#if>
</#macro>


</html>