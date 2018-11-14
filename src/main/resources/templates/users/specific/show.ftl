<div>
        <div>${i.getId()}</div>
        <#if i.getFirstname()??>
        <div>${i.getFirstname()}</div>
        <#else>
        <div>NULL</div>
        </#if>
        <#if i.getLastname()??>
        <div>${i.getLastname()}</div>
        <#else>
        <div>NULL</div>
        </#if>
        <div>
            <a href="${detailPath}/edit/${i.getId()}">Show</a>
            <a href="${detailPath}/delete/${i.getId()}">Delete</a>
        </div>
    </div>