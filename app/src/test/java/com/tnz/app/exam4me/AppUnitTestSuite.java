package com.tnz.app.exam4me;

import com.tnz.app.exam4me.Factory.FacultyFactoryTest;
import com.tnz.app.exam4me.Factory.LecturerFactoryTest;
import com.tnz.app.exam4me.Factory.StudentTypeFactoryTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        FacultyFactoryTest.class,
        LecturerFactoryTest.class,
        StudentTypeFactoryTest.class,
        })

public class AppUnitTestSuite {}
