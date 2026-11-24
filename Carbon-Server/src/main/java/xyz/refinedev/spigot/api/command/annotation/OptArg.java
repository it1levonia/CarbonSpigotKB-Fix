package xyz.refinedev.spigot.api.command.annotation;

import xyz.refinedev.spigot.api.command.annotation.LastArg;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@LastArg
public @interface OptArg {

    String value() default "";

}
