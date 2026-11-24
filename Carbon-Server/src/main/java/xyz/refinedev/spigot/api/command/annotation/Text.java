package xyz.refinedev.spigot.api.command.annotation;

import xyz.refinedev.spigot.api.command.annotation.Classifier;
import xyz.refinedev.spigot.api.command.annotation.LastArg;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Classifier
@LastArg
public @interface Text {
}
