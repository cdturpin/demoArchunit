package com.keyholesoftware.demo.archunit.config;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;
import static com.tngtech.archunit.library.GeneralCodingRules.USE_JAVA_UTIL_LOGGING;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING;

import org.junit.runner.RunWith;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;

/**
 * @author Cynthia.Turpin
 * 
 *	No classes should be throwing generic exceptions
 *	Don't write to System.out (use logging instead)
 *	No class should be using Java Util Logging 
 *	Housekeeping works like DAO classes should be in DAO packages or Entities should reside in Domain or Model packages.
 *	Interfaces should not be placed in implementation packages
 *	Interface classes should not start or end with interface word.
 *	Layered dependencies — Like Services should not access Controller classes or DAO/Persistence classes should not access services.
 *	Proper use of Java Security packages
 *	Conscious use of third party libraries
 * 
 *
 */
@RunWith(ArchUnitRunner.class)
@AnalyzeClasses
public class LayeredArchRulesTest {
	
	
	JavaClasses classes = new ClassFileImporter()
			.withImportOption(ImportOption.Predefined.DONT_INCLUDE_JARS)
			.withImportOption(ImportOption.Predefined.DONT_INCLUDE_TESTS)
			.importPackages("com.keyholesoftware.demo.archunit");
	
 	@ArchTest
    public static final ArchRule NO_ACCESS_TO_STANDARD_STREAMS = NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;

    @ArchTest
    public static final ArchRule NO_GENERIC_EXCEPTIONS = NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;

    @ArchTest
    public static final ArchRule NO_JAVA_UTIL_LOGGING = NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING;

    @ArchTest
    public static void no_java_util_logging_as_method(JavaClasses classes) {
        noClasses().should(USE_JAVA_UTIL_LOGGING).check(classes);
    }

	@ArchTest
	public static final ArchRule layer_dependencies_are_respected = layeredArchitecture()
			.layer("Controllers").definedBy("com.keyholesoftware.demo.archunit.controller..").layer("Services")
			.definedBy("com.keyholesoftware.demo.archunit.service..").layer("Persistence")
			.definedBy("com.keyholesoftware.demo.archunit.persistence..")
			.whereLayer("Controllers").mayNotBeAccessedByAnyLayer().whereLayer("Services")
			.mayOnlyBeAccessedByLayers("Controllers").whereLayer("Persistence").mayOnlyBeAccessedByLayers("Services");

	@ArchTest
	public static final ArchRule layer_dependencies_are_respected_with_exception = layeredArchitecture()
			.layer("Controllers").definedBy("com.keyholesoftware.demo.archunit.controller..").layer("Services")
			.definedBy("com.keyholesoftware.demo.archunit.service..").layer("Persistence")
			.definedBy("com.keyholesoftware.demo.archunit.persistence..")
			.whereLayer("Controllers").mayNotBeAccessedByAnyLayer().whereLayer("Services")
			.mayOnlyBeAccessedByLayers("Controllers").whereLayer("Persistence").mayOnlyBeAccessedByLayers("Services");
	
	@ArchTest
	public static void services_should_not_access_controllers(JavaClasses classes) {
		noClasses().that().resideInAPackage("..service..").should().accessClassesThat()
				.resideInAPackage("..controller..").check(classes);
	}

	@ArchTest
	public static void persistence_should_not_access_services(JavaClasses classes) {
		noClasses().that().resideInAPackage("..com.keyholesoftware.demo.archunit.persistence..").should().accessClassesThat()
				.resideInAPackage("..service..").check(classes);
	}

	@ArchTest
	public static void services_should_only_be_accessed_by_controllers_or_other_services(JavaClasses classes) {
		classes().that().resideInAPackage("..service..").should().onlyBeAccessed()
				.byAnyPackage("..controller..", "..service..").check(classes);
	}
}