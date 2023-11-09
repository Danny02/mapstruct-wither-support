package dev.nullzwo.wither;

import org.mapstruct.ap.spi.DefaultAccessorNamingStrategy;
import org.mapstruct.ap.spi.util.IntrospectorUtils;

import javax.lang.model.element.ExecutableElement;

public class WitherAccessorNamingStrategy extends DefaultAccessorNamingStrategy {

    @Override
    public String getPropertyName(ExecutableElement getterOrSetterMethod) {
        String methodName = getterOrSetterMethod.getSimpleName().toString();

        var otherName = super.getPropertyName(getterOrSetterMethod);
        if (!otherName.equals(methodName)) {
            return otherName;
        }

        if (isFluentSetter(getterOrSetterMethod)) {
            if (methodName.startsWith("with")
                && methodName.length() > 4
                && Character.isUpperCase(methodName.charAt(4))) {
                return IntrospectorUtils.decapitalize(methodName.substring(4));
            }
        }

        return methodName;
    }
}
